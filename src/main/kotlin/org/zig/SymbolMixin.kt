package org.zig

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

abstract class SymbolMixin(node: ASTNode) : ASTWrapperPsiElement(node) {
  override fun getReference(): PsiReference? {
    return ZigFnCallReference(this, node.firstChildNode?.psi!!)
  }
}