package org.zig.types

import com.intellij.psi.PsiElement
import org.zig.psi.ZigPrimaryTypeExpr
import org.zig.psi.ZigSuffixOp

fun getTypeFromChain(start: ZigPrimaryTypeExpr, end: PsiElement): Type? {
  var t = start.type
  var s = start.nextSibling
  while (s != end) {
    when(s) {
      is ZigSuffixOp -> {
        val fieldName = s.symbol?.firstChild?.text ?: return null
        when (t) {
          is StructType -> {
            t = t.fields[fieldName]
            s = s.nextSibling
          }
        }
      }
    }
  }

  return t
}