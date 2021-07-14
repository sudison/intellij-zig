package org.zig.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import org.zig.psi.VarDeclaration
import org.zig.psi.ZigContainerDecl
import org.zig.psi.ZigContainerField
import org.zig.psi.ZigLangTypes

open class LocalVarDecl(node: ASTNode) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner, VarDeclaration {
  override fun setName(name: String): PsiElement {
    TODO("Not yet implemented")
  }

  override fun getNameIdentifier(): PsiElement? {
    val childNode = node.findChildByType(ZigLangTypes.VAR_DECL)

    val idNode = childNode?.findChildByType(ZigLangTypes.ID)
    return idNode?.psi
  }

  override fun isContainerType(): Boolean {
    return PsiTreeUtil.findChildOfType(node.psi, ZigContainerDecl::class.java) != null
  }
}