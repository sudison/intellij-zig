package org.zig

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import org.zig.psi.ZigFnDecl
import org.zig.psi.ZigLangTypes

class ZigReferenceContributor : PsiReferenceContributor() {
  override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
    registrar.registerReferenceProvider(psiElement(ZigLangTypes.ID), ZigReferenceProvider())
  }
}

class ZigReferenceProvider: PsiReferenceProvider() {
  override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
    val s = element.prevSibling
    return PsiReference.EMPTY_ARRAY
  }
}


class ZigFnCallReference(element: PsiElement, private val idOpt: PsiElement?): PsiPolyVariantReferenceBase<PsiElement>(element) {

  override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
    val funs = PsiTreeUtil.collectElementsOfType(element.containingFile
                                               , ZigFnDecl::class.java)
    return funs.map { PsiElementResolveResult(it, true) }.toTypedArray()
  }

  override fun calculateDefaultRangeInElement(): TextRange {
    val id = idOpt ?: return TextRange.EMPTY_RANGE
    return TextRange.from(id.startOffsetInParent, id.textLength)
  }
}