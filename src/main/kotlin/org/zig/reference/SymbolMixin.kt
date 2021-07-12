package org.zig.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import com.intellij.psi.util.PsiTreeUtil
import org.zig.ZigReference
import org.zig.psi.ZigBlock

abstract class SymbolMixin(node: ASTNode) : ASTWrapperPsiElement(node) {
  override fun getReference(): PsiReference? {
    PsiTreeUtil.getParentOfType(this, ZigBlock::class.java)
    return ZigReference(this, node.firstChildNode?.psi!!)
  }
}