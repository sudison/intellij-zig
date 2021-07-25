package org.zig.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.util.PsiTreeUtil
import org.zig.ZigReference
import org.zig.psi.ZigFieldInit
import org.zig.psi.ZigLangTypes
import org.zig.psi.ZigPrimaryTypeExpr
import org.zig.psi.ZigSuffixOp
import org.zig.types.Type
import org.zig.types.getTypeFromChain
import org.zig.types.type

abstract class SymbolMixin(node: ASTNode) : ASTWrapperPsiElement(node) {
  override fun getReference(): PsiReference? {
    val ps = prevSibling
    var containerType: Type? = null
    if (ps?.text == ZigLangTypes.DOT.toString() && parent is ZigSuffixOp) {
      val pTypeExpr: PsiElement? = PsiTreeUtil.findSiblingBackward(parent, ZigLangTypes.PRIMARY_TYPE_EXPR, null)
      containerType = getTypeFromChain(pTypeExpr as ZigPrimaryTypeExpr, parent)
    } else if (ps?.text == ZigLangTypes.DOT.toString() && parent is ZigFieldInit) {
      val pTypeExpr: PsiElement? = PsiTreeUtil.findSiblingBackward(parent.parent, ZigLangTypes.PRIMARY_TYPE_EXPR, null)
      containerType = (pTypeExpr as ZigPrimaryTypeExpr).type
    }

    return if (containerType != null) {
      ZigContainerTypeReference(this, node.firstChildNode?.psi!!, containerType)
    } else ZigReference(this, node.firstChildNode?.psi!!)
  }
}