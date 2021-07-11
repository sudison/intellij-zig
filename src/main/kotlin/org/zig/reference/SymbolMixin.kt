package org.zig.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import org.zig.ZigTopLevelReference

abstract class SymbolMixin(node: ASTNode) : ASTWrapperPsiElement(node) {
  override fun getReference(): PsiReference? {
    return ZigTopLevelReference(this, node.firstChildNode?.psi!!)
  }
}