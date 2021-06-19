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

public class ZigVarDeclImpl extends ASTWrapperPsiElement implements ZigVarDecl {

  public ZigVarDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitVarDecl(this);
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
  public ZigExpr getExpr() {
    return findChildByClass(ZigExpr.class);
  }

  @Override
  @Nullable
  public ZigLinkSection getLinkSection() {
    return findChildByClass(ZigLinkSection.class);
  }

  @Override
  @Nullable
  public ZigTypeExpr getTypeExpr() {
    return findChildByClass(ZigTypeExpr.class);
  }

}
