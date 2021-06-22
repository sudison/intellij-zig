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

public class ZigLoopTypeExprImpl extends ASTWrapperPsiElement implements ZigLoopTypeExpr {

  public ZigLoopTypeExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitLoopTypeExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ZigForTypeExpr getForTypeExpr() {
    return findChildByClass(ZigForTypeExpr.class);
  }

  @Override
  @Nullable
  public ZigWhileTypeExpr getWhileTypeExpr() {
    return findChildByClass(ZigWhileTypeExpr.class);
  }

}
