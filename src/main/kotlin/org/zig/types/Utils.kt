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
          is FieldType -> {
            when(val ft = t.type) {
              is StructType -> {
                t = ft.fields[fieldName]
                s = s.nextSibling
              }
              else -> return null
            }
          }
          else -> return null
        }
      }
      else -> return null
    }
  }

  return t
}