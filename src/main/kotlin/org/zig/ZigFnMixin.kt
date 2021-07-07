package org.zig

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReference
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
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

  override fun getReference(): PsiReference? {
    return ZigFnCallReference(this, nameIdentifier)
  }

  override fun setName(name: String): PsiElement {
    TODO("Not yet implemented")
  }

  override fun getName(): String? = nameIdentifier?.text

  override fun processDeclarations(
    processor: PsiScopeProcessor,
    state: ResolveState,
    lastParent: PsiElement?,
    place: PsiElement
  ): Boolean {
    return super.processDeclarations(processor, state, lastParent, place)
  }
}