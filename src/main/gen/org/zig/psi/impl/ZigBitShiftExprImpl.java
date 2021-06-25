// This is a generated file. Not intended for manual editing.
package org.zig.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.zig.psi.ZigLangTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.zig.psi.*;

public class ZigBitShiftExprImpl extends ASTWrapperPsiElement implements ZigBitShiftExpr {

  public ZigBitShiftExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitBitShiftExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ZigAdditionExpr> getAdditionExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigAdditionExpr.class);
  }

  @Override
  @NotNull
  public List<ZigBitShiftOp> getBitShiftOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigBitShiftOp.class);
  }

}
