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

public class ZigAdditionExprImpl extends ASTWrapperPsiElement implements ZigAdditionExpr {

  public ZigAdditionExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitAdditionExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ZigAdditionOp> getAdditionOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigAdditionOp.class);
  }

  @Override
  @NotNull
  public List<ZigMultiplyExpr> getMultiplyExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigMultiplyExpr.class);
  }

}
