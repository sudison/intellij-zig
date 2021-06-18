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

public class ZigPrefixTypeOpImpl extends ASTWrapperPsiElement implements ZigPrefixTypeOp {

  public ZigPrefixTypeOpImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitPrefixTypeOp(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ZigArrayTypeStart getArrayTypeStart() {
    return findChildByClass(ZigArrayTypeStart.class);
  }

  @Override
  @NotNull
  public List<ZigByteAlign> getByteAlignList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigByteAlign.class);
  }

  @Override
  @NotNull
  public List<ZigExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigExpr.class);
  }

  @Override
  @Nullable
  public ZigPtrTypeStart getPtrTypeStart() {
    return findChildByClass(ZigPtrTypeStart.class);
  }

  @Override
  @Nullable
  public ZigSliceTypeStart getSliceTypeStart() {
    return findChildByClass(ZigSliceTypeStart.class);
  }

}
