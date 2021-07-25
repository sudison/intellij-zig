package org.zig

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import org.zig.psi.*
import org.zig.reference.createLookup

class ZigReferenceContributor : PsiReferenceContributor() {
  override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
    registrar.registerReferenceProvider(psiElement(ZigLangTypes.ID), ZigReferenceProvider())
  }
}

class ZigReferenceProvider : PsiReferenceProvider() {
  override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
    val s = element.prevSibling
    return PsiReference.EMPTY_ARRAY
  }
}

class ZigReference(element: PsiElement, private val id: PsiElement) :
  PsiPolyVariantReferenceBase<PsiElement>(element) {

  private fun topLevelRefs(): List<ResolveResult> {
    val refFuns = PsiTreeUtil.collectElementsOfType(
      element.containingFile, ZigFnDecl::class.java
    ).filter { it.nameIdentifier?.text == id.text }
    val topVarDecl = PsiTreeUtil.collectElementsOfType(
      element.containingFile, ZigTopVarDecl::class.java
    ).filter { it.nameIdentifier?.text == id.text }
    return (refFuns.map { PsiElementResolveResult(it, true) } + topVarDecl.map {
      PsiElementResolveResult(
        it,
        true
      )
    })
  }


  private fun localVarResolve(): List<ResolveResult> {
    val refs = mutableListOf<ResolveResult>()
    psiTreeWalkupInsideBlock(element) {
      if (it.nameIdentifier?.text == id.text) {
        refs.add(PsiElementResolveResult(it, true))
      }
      false
    }
    return refs
  }

  override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {

    return (topLevelRefs() + localVarResolve()).toTypedArray()
  }

  override fun calculateDefaultRangeInElement(): TextRange {
    return TextRange.from(id.startOffsetInParent, id.textLength)
  }


  override fun getVariants(): Array<Any> {
    val refFuns = PsiTreeUtil.collectElementsOfType(
      element.containingFile, ZigFnDecl::class.java
    )
    val topVarDecl = PsiTreeUtil.collectElementsOfType(
      element.containingFile, ZigTopVarDecl::class.java
    )
    val localVars = mutableListOf<PsiNameIdentifierOwner>()
    psiTreeWalkupInsideBlock(element) {
      localVars.add(it)
      false
    }


    return (refFuns.map {
      createLookup(it.nameIdentifier?.text!!)
    } + topVarDecl.map {
      createLookup(it.nameIdentifier?.text!!)
    }
      + localVars.map {
      createLookup(it.nameIdentifier?.text!!)
    })
      .toTypedArray()
  }
}