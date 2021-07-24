package org.zig.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import org.zig.psi.ZigLangTypes

open class ContainerFieldMixin(node: ASTNode) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner {
  override fun setName(name: String): PsiElement {
    TODO("Not yet implemented")
  }

  override fun getNameIdentifier(): PsiElement? {
    return node.findChildByType(ZigLangTypes.ID)?.psi
  }
}