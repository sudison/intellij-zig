package org.zig.types

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import org.zig.ZigLangHelper.primitiveTypes
import org.zig.psi.*

private fun getStructType(e: ZigContainerDecl): StructType {
  val fieldNameToTypeMap =
    PsiTreeUtil
      .findChildrenOfType(e, ZigContainerField::class.java)
      .associate {
        it.firstChild?.text!! to FieldType(it,PsiTreeUtil.findChildOfType(e, ZigPrimaryTypeExpr::class.java)?.type)
      }
  return StructType(e, fieldNameToTypeMap)
}

val ZigContainerDecl.type: Type?
  get() {
    return when(firstChild?.firstChild?.text) {
      ZigLangTypes.STRUCT.toString().toLowerCase() -> getStructType(this)
      else -> null
    }
  }

val ZigSymbol.type: Type?
  get() {
    val id = firstChild?.text ?: return null
    return if (id in primitiveTypes) {
      BuildinType(id)
    } else {
      val e = findPsiElementByNameInsideFile(id, this)
      e?.type
    }
  }

val ZigPrimaryTypeExpr.type: Type?
  get() {
    return when (val c = firstChild) {
      is ZigContainerDecl -> c.type
      is ZigSymbol -> c.type
      else -> null
    }
  }

val ZigTopVarDecl.type: Type?
  get() {
    return PsiTreeUtil.findChildOfType(this, ZigPrimaryTypeExpr::class.java)?.type
  }

val ZigLocalVarDecl.type: Type?
  get() {
    return PsiTreeUtil.findChildOfType(this, ZigPrimaryTypeExpr::class.java)?.type
  }

val PsiElement.type: Type?
  get() {
    return when (this) {
      is ZigTopVarDecl -> type
      is ZigLocalVarDecl -> type
      else -> null
    }
  }

