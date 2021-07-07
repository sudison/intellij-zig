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

public class ZigStatementImpl extends ASTWrapperPsiElement implements ZigStatement {

  public ZigStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ZigAssignStatement getAssignStatement() {
    return findChildByClass(ZigAssignStatement.class);
  }

  @Override
  @Nullable
  public ZigBlockExprStatement getBlockExprStatement() {
    return findChildByClass(ZigBlockExprStatement.class);
  }

  @Override
  @Nullable
  public ZigIfStatement getIfStatement() {
    return findChildByClass(ZigIfStatement.class);
  }

  @Override
  @Nullable
  public ZigLabeledStatement getLabeledStatement() {
    return findChildByClass(ZigLabeledStatement.class);
  }

  @Override
  @Nullable
  public ZigPayload getPayload() {
    return findChildByClass(ZigPayload.class);
  }

  @Override
  @Nullable
  public ZigSwitchExpr getSwitchExpr() {
    return findChildByClass(ZigSwitchExpr.class);
  }

  @Override
  @Nullable
  public ZigVarDecl getVarDecl() {
    return findChildByClass(ZigVarDecl.class);
  }

}
