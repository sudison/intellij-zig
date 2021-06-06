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

public class ZigAsyncExprImpl extends ASTWrapperPsiElement implements ZigAsyncExpr {

  public ZigAsyncExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitAsyncExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ZigAsmExpr> getAsmExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigAsmExpr.class);
  }

  @Override
  @NotNull
  public List<ZigBlockExpr> getBlockExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigBlockExpr.class);
  }

  @Override
  @NotNull
  public List<ZigContainerExpr> getContainerExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigContainerExpr.class);
  }

  @Override
  @NotNull
  public List<ZigContinueExpr> getContinueExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigContinueExpr.class);
  }

  @Override
  @NotNull
  public List<ZigExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigExpr.class);
  }

  @Override
  @NotNull
  public ZigFnCallSuffix getFnCallSuffix() {
    return findNotNullChildByClass(ZigFnCallSuffix.class);
  }

  @Override
  @NotNull
  public List<ZigGroupedExpr> getGroupedExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigGroupedExpr.class);
  }

  @Override
  @NotNull
  public List<ZigMacroExpr> getMacroExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigMacroExpr.class);
  }

}
