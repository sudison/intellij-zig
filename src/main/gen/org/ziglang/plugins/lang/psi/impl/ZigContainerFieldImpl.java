// This is a generated file. Not intended for manual editing.
package org.ziglang.plugins.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.ziglang.plugins.lang.psi.ZigTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.ziglang.plugins.lang.psi.*;

public class ZigContainerFieldImpl extends ASTWrapperPsiElement implements ZigContainerField {

  public ZigContainerFieldImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitContainerField(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ZigAsmExpr getAsmExpr() {
    return findChildByClass(ZigAsmExpr.class);
  }

  @Override
  @Nullable
  public ZigBlockExpr getBlockExpr() {
    return findChildByClass(ZigBlockExpr.class);
  }

  @Override
  @Nullable
  public ZigContainerExpr getContainerExpr() {
    return findChildByClass(ZigContainerExpr.class);
  }

  @Override
  @Nullable
  public ZigContinueExpr getContinueExpr() {
    return findChildByClass(ZigContinueExpr.class);
  }

  @Override
  @NotNull
  public List<ZigExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigExpr.class);
  }

  @Override
  @Nullable
  public ZigGroupedExpr getGroupedExpr() {
    return findChildByClass(ZigGroupedExpr.class);
  }

  @Override
  @Nullable
  public ZigMacroExpr getMacroExpr() {
    return findChildByClass(ZigMacroExpr.class);
  }

}
