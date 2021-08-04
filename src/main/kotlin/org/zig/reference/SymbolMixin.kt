package org.zig.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.TokenType
import com.intellij.psi.util.PsiTreeUtil
import org.zig.ZigReference
import org.zig.psi.*
import org.zig.types.*

abstract class SymbolMixin(node: ASTNode) : ASTWrapperPsiElement(node) {
  override fun getReference(): PsiReference? {
    val ps = prevSibling
    var containerType: Type? = null
    if (ps?.text == ZigLangTypes.DOT.toString() && parent is ZigSuffixOp) {
      val pTypeExpr: PsiElement? = PsiTreeUtil.findSiblingBackward(parent, ZigLangTypes.PRIMARY_TYPE_EXPR, null)
      containerType = getTypeFromChain(pTypeExpr as ZigPrimaryTypeExpr, parent)
    } else if (ps?.text == ZigLangTypes.DOT.toString() && parent is ZigFieldInit) {
      val pTypeExpr: PsiElement? = PsiTreeUtil.findSiblingBackward(parent.parent, ZigLangTypes.PRIMARY_TYPE_EXPR, null)
      containerType = (pTypeExpr as ZigPrimaryTypeExpr).inference()
    } else if (parent is ZigPrimaryTypeExpr && parent.prevSiblingTypeIgnoring(ZigLangTypes.COLON, TokenType.WHITE_SPACE) != null) {
      return ZigTypeReference(this, node.firstChildNode?.psi!!)
    } else if (parent is ZigPrimaryTypeExpr && parent.parent is ZigFnProto) {
      return ZigTypeReference(this, node.firstChildNode?.psi!!)
    } else if (parent is ZigPrimaryTypeExpr && parent.parent is ZigParamType) {
      return ZigTypeReference(this, node.firstChildNode?.psi!!)
    }

    return if (containerType != null) {
      ZigContainerTypeReference(this, node.firstChildNode?.psi!!, containerType)
    } else ZigReference(this, node.firstChildNode?.psi!!)
  }
}