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

public class ZigForStatementImpl extends ASTWrapperPsiElement implements ZigForStatement {

  public ZigForStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitForStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ZigAssignExpr getAssignExpr() {
    return findChildByClass(ZigAssignExpr.class);
  }

  @Override
  @Nullable
  public ZigBlockExpr getBlockExpr() {
    return findChildByClass(ZigBlockExpr.class);
  }

  @Override
  @NotNull
  public ZigForPrefix getForPrefix() {
    return findNotNullChildByClass(ZigForPrefix.class);
  }

  @Override
  @Nullable
  public ZigStatement getStatement() {
    return findChildByClass(ZigStatement.class);
  }

}
