package org.zig.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import org.zig.psi.ZigLangTypes

abstract class ZigFnMixin(node: ASTNode) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner {
  override fun getNameIdentifier(): PsiElement? {
    val childNode = node.findChildByType(ZigLangTypes.FN_PROTO)
    val idNode = childNode?.findChildByType(ZigLangTypes.ID)
    return idNode?.psi
  }

  override fun getTextOffset(): Int {
    val offset = nameIdentifier?.textOffset

    return offset ?: super.getTextOffset()
  }

  override fun setName(name: String): PsiElement {
    TODO("Not yet implemented")
  }

  override fun getName(): String? = nameIdentifier?.text
}