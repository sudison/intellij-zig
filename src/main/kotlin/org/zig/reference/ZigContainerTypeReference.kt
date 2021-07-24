package org.zig.reference

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult
import org.zig.types.FieldType
import org.zig.types.StructType
import org.zig.types.Type

class ZigContainerTypeReference(element: PsiElement, private val id: PsiElement, private val containerType: Type?) :
  PsiPolyVariantReferenceBase<PsiElement>(element) {
  override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {

    val r = when (containerType) {
      is StructType -> {
        containerType.fields[id.text]?.reference()
      }
      else -> null
    }
    r?: return listOf<ResolveResult>().toTypedArray()
    return listOf<ResolveResult>(PsiElementResolveResult(r, true)).toTypedArray()
  }

  override fun calculateDefaultRangeInElement(): TextRange {
    return TextRange.from(id.startOffsetInParent, id.textLength)
  }

  override fun getVariants(): Array<Any> {
   return when (containerType) {
      is StructType -> {
        containerType.fields.keys.map { createLookup(it) }.toTypedArray()
      }
     is FieldType -> {
       when(val t = containerType.type) {
         is StructType -> {
           t.fields.keys.map { createLookup(it) }.toTypedArray()
         }
         else -> listOf<LookupElement>().toTypedArray()
       }
     }
     else -> listOf<LookupElement>().toTypedArray()
   }
  }
}