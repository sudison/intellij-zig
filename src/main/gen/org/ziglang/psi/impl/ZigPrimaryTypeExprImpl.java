// This is a generated file. Not intended for manual editing.
package org.ziglang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.ziglang.psi.ZigLangTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.ziglang.psi.*;

public class ZigPrimaryTypeExprImpl extends ASTWrapperPsiElement implements ZigPrimaryTypeExpr {

  public ZigPrimaryTypeExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitPrimaryTypeExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ZigByteAlign getByteAlign() {
    return findChildByClass(ZigByteAlign.class);
  }

  @Override
  @Nullable
  public ZigCallConv getCallConv() {
    return findChildByClass(ZigCallConv.class);
  }

  @Override
  @Nullable
  public ZigContainerDecl getContainerDecl() {
    return findChildByClass(ZigContainerDecl.class);
  }

  @Override
  @Nullable
  public ZigErrorSetDecl getErrorSetDecl() {
    return findChildByClass(ZigErrorSetDecl.class);
  }

  @Override
  @Nullable
  public ZigFnCallArguments getFnCallArguments() {
    return findChildByClass(ZigFnCallArguments.class);
  }

  @Override
  @Nullable
  public ZigGroupedExpr getGroupedExpr() {
    return findChildByClass(ZigGroupedExpr.class);
  }

  @Override
  @Nullable
  public ZigIfTypeExpr getIfTypeExpr() {
    return findChildByClass(ZigIfTypeExpr.class);
  }

  @Override
  @Nullable
  public ZigInitList getInitList() {
    return findChildByClass(ZigInitList.class);
  }

  @Override
  @Nullable
  public ZigLabeledTypeExpr getLabeledTypeExpr() {
    return findChildByClass(ZigLabeledTypeExpr.class);
  }

  @Override
  @Nullable
  public ZigLinkSection getLinkSection() {
    return findChildByClass(ZigLinkSection.class);
  }

  @Override
  @Nullable
  public ZigParamDeclList getParamDeclList() {
    return findChildByClass(ZigParamDeclList.class);
  }

  @Override
  @Nullable
  public ZigStringliteral getStringliteral() {
    return findChildByClass(ZigStringliteral.class);
  }

  @Override
  @Nullable
  public ZigSwitchExpr getSwitchExpr() {
    return findChildByClass(ZigSwitchExpr.class);
  }

  @Override
  @Nullable
  public ZigTypeExpr getTypeExpr() {
    return findChildByClass(ZigTypeExpr.class);
  }

}
