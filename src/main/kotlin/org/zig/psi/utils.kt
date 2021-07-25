package org.zig.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil

fun PsiElement.prevSiblingTypeIgnoring(
  type: IElementType,
  vararg types: IElementType
): PsiElement? {
  var next: PsiElement? = prevSibling
  while (true) {
    val localNext = next ?: return null
    next = localNext.prevSibling
    return if (types.any { localNext.node.elementType == it }) continue
    else localNext.takeIf { it.node.elementType == type }
  }
}

fun psiTreeWalkupInsideBlock(element: PsiElement, consumer: (PsiNameIdentifierOwner) -> Boolean) {
  var statement = PsiTreeUtil.findFirstParent(element) { it is ZigStatement }
  while (statement != null) {
    var e: PsiElement? = statement.prevSibling
    while (e != null) {
      if (ZigLangTypes.STATEMENT == e.node.elementType) {
        val localVarDecl = e.firstChild
        if (localVarDecl is ZigLocalVarDecl) {
          if (consumer(localVarDecl)) return
        }
      }
      e = e.prevSibling
    }

    val block = PsiTreeUtil.findFirstParent(statement) { it is ZigBlock }
    statement = PsiTreeUtil.findFirstParent(block) { it is ZigStatement }
  }
}

fun findPsiElementByNameInsideBlock(name: String, start: PsiElement): PsiElement? {
  var e: PsiElement? = null
  psiTreeWalkupInsideBlock(start) {
    if (it.nameIdentifier?.text == name) {
      e = it
      true
    } else {
      false
    }
  }
  return e
}

fun findPsiElementByNameInsideFile(name: String, start: PsiElement): PsiElement? {
  val found = findPsiElementByNameInsideBlock(name, start)
  if (found != null) return found

  return PsiTreeUtil.collectElementsOfType(
    start.containingFile, ZigTopVarDecl::class.java
  ).firstOrNull { it.nameIdentifier?.text == name }
}

private fun isElementAType(e: PsiElement): Boolean {
  return ((e is ZigTopVarDecl || e is ZigLocalVarDecl) && PsiTreeUtil.findChildOfType(e, ZigContainerDecl::class.java) != null) || e is ZigFnDecl
}

fun findTypesInsideBlock(start: PsiElement): List<PsiNameIdentifierOwner> {
  val types = mutableListOf<PsiNameIdentifierOwner>()
  psiTreeWalkupInsideBlock(start) {
    if (isElementAType(it)) {
      types.add(it)
    }
    false
  }
  return types
}

fun findTopLevelTypes(e: PsiElement): List<PsiNameIdentifierOwner> {
  val types = mutableListOf<PsiNameIdentifierOwner>()

  PsiTreeUtil.collectElementsOfType(
    e.containingFile, ZigTopVarDecl::class.java
  ).forEach {
    if (isElementAType(it)) {
      types.add(it)
    }
  }

  PsiTreeUtil.collectElementsOfType(
    e.containingFile, ZigFnDecl::class.java
  ).forEach {
    if (isElementAType(it)) {
      types.add(it)
    }
  }
  return types
}

fun findTypesInsideFile(start: PsiElement): List<PsiNameIdentifierOwner> {
  val types = mutableListOf<PsiNameIdentifierOwner>()
  types.addAll(findTypesInsideBlock(start))
  types.addAll(findTopLevelTypes(start))
  return types
}