package org.zig

import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import org.zig.psi.*

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

  private fun localVarRef(consumer: (ZigLocalVarDecl) -> Unit): Unit {
    var statement = PsiTreeUtil.findFirstParent(element) { it is ZigStatement }
    while (statement != null) {
      var e: PsiElement? = statement.prevSibling
      while (e != null) {
        if (ZigLangTypes.STATEMENT == e.node.elementType) {
          val localVarDecl = e.firstChild
          if (localVarDecl is ZigLocalVarDecl) {
            consumer(localVarDecl)
          }
        }
        e = e.prevSibling
      }

      val block = PsiTreeUtil.findFirstParent(statement) { it is ZigBlock }
      statement = PsiTreeUtil.findFirstParent(block) { it is ZigStatement }
    }

  }

  private fun localVarResolve(): List<ResolveResult> {
    val refs = mutableListOf<ResolveResult>()
    localVarRef {
      if (it.nameIdentifier?.text == id.text) {
        refs.add(PsiElementResolveResult(it, true))
      }
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
    val localVars = mutableListOf<ZigLocalVarDecl>()
    localVarRef { localVars.add(it) }

    fun createLookup(e: PsiNameIdentifierOwner): LookupElement {
      return LookupElementBuilder
        .create(e.nameIdentifier?.text!!)
        .withPresentableText(e.nameIdentifier?.text!!)
        .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
    }
    return (refFuns.map {
      createLookup(it)
    } + topVarDecl.map {
      createLookup(it)
    }
      + localVars.map {
      createLookup(it)
    })
      .toTypedArray()
  }
}