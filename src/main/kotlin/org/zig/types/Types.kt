package org.zig.types

import com.intellij.psi.PsiElement


open class Type(val owner: PsiElement?) {
  fun reference(): PsiElement? {
    return owner
  }
}

class FieldType(ref: PsiElement, val type: Type?) : Type(ref)

class StructType(owner: PsiElement, val fields: Map<String, FieldType?>) : Type(owner)

class FnType(owner: PsiElement, var returnType: Type?) : Type(owner)

class BuildinType(name: String) : Type(null)

class EnumType(owner: PsiElement?) : Type(owner)
