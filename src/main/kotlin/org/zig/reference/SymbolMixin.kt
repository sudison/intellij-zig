package org.zig.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import com.intellij.psi.util.PsiTreeUtil
import org.zig.ZigReference
import org.zig.ZigTypeReference
import org.zig.psi.ZigBlock
import org.zig.psi.ZigContainerField

abstract class SymbolMixin(node: ASTNode) : ASTWrapperPsiElement(node) {
  override fun getReference(): PsiReference? {
    val partOfContainer = PsiTreeUtil.getParentOfType(this, ZigContainerField::class.java)
    return if (partOfContainer == null) {
      ZigReference(this, node.firstChildNode?.psi!!)
    } else {
      ZigTypeReference(this, node.firstChildNode?.psi!!)
    }
  }
}