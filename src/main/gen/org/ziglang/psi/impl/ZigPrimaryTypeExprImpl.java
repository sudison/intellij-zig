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
  public ZigBuiltinidentifier getBuiltinidentifier() {
    return findChildByClass(ZigBuiltinidentifier.class);
  }

  @Override
  @Nullable
  public ZigFnCallArguments getFnCallArguments() {
    return findChildByClass(ZigFnCallArguments.class);
  }

  @Override
  @Nullable
  public ZigStringliteral getStringliteral() {
    return findChildByClass(ZigStringliteral.class);
  }

}
