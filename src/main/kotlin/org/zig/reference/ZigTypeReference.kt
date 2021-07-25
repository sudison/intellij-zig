package org.zig.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult
import org.zig.ZigLangHelper
import org.zig.psi.findTypesInsideFile

class ZigTypeReference(element: PsiElement, private val id: PsiElement) :
  PsiPolyVariantReferenceBase<PsiElement>(element) {
  override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
    val r = mutableListOf<ResolveResult>()
    val e = findTypesInsideFile(element).find {
      it.nameIdentifier?.text == id.text
    }
    if (e != null) r.add(PsiElementResolveResult(e, true))
    return r.toTypedArray()
  }

  override fun calculateDefaultRangeInElement(): TextRange {
    return TextRange.from(id.startOffsetInParent, id.textLength)
  }

  override fun getVariants(): Array<Any> {
    return (findTypesInsideFile(element).map {
      createLookup(it.nameIdentifier?.text!!)
    } + ZigLangHelper.primitiveTypesLookup).toTypedArray()
  }
}