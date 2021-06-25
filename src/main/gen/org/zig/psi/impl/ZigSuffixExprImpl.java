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

public class ZigSuffixExprImpl extends ASTWrapperPsiElement implements ZigSuffixExpr {

  public ZigSuffixExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitSuffixExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ZigFnCallArguments> getFnCallArgumentsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigFnCallArguments.class);
  }

  @Override
  @NotNull
  public ZigPrimaryTypeExpr getPrimaryTypeExpr() {
    return findNotNullChildByClass(ZigPrimaryTypeExpr.class);
  }

  @Override
  @NotNull
  public List<ZigSuffixOp> getSuffixOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigSuffixOp.class);
  }

}
