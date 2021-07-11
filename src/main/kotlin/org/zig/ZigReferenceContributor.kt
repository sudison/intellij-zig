package org.zig

import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import org.zig.psi.ZigFnDecl
import org.zig.psi.ZigLangTypes
import org.zig.psi.ZigTopVarDecl

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

class ZigTopLevelReference(element: PsiElement, private val id: PsiElement) :
  PsiPolyVariantReferenceBase<PsiElement>(element) {


  override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
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
    }).toTypedArray()
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
    return (refFuns.map {
      LookupElementBuilder
        .create(it.nameIdentifier?.text!!)
        .withPresentableText(it.nameIdentifier?.text!!)
        .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
    } + topVarDecl.map {
      LookupElementBuilder
        .create(it.nameIdentifier?.text!!)
        .withPresentableText(it.nameIdentifier?.text!!)
        .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
    }).toTypedArray()
  }
}