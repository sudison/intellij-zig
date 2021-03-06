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

public class ZigContainerDeclImpl extends ASTWrapperPsiElement implements ZigContainerDecl {

  public ZigContainerDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitContainerDecl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ZigContainerDeclType getContainerDeclType() {
    return findChildByClass(ZigContainerDeclType.class);
  }

  @Override
  @NotNull
  public List<ZigContainerField> getContainerFieldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigContainerField.class);
  }

  @Override
  @NotNull
  public List<ZigExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigExpr.class);
  }

  @Override
  @NotNull
  public List<ZigFnDecl> getFnDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigFnDecl.class);
  }

  @Override
  @NotNull
  public List<ZigTestDecl> getTestDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigTestDecl.class);
  }

  @Override
  @NotNull
  public List<ZigTopLevelComptime> getTopLevelComptimeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigTopLevelComptime.class);
  }

  @Override
  @NotNull
  public List<ZigTopVarDecl> getTopVarDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigTopVarDecl.class);
  }

}
