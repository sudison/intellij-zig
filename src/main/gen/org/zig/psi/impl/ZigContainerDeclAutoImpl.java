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

public class ZigContainerDeclAutoImpl extends ASTWrapperPsiElement implements ZigContainerDeclAuto {

  public ZigContainerDeclAutoImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitContainerDeclAuto(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ZigBlock> getBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigBlock.class);
  }

  @Override
  @NotNull
  public List<ZigByteAlign> getByteAlignList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigByteAlign.class);
  }

  @Override
  @NotNull
  public List<ZigCallConv> getCallConvList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigCallConv.class);
  }

  @Override
  @NotNull
  public ZigContainerDeclType getContainerDeclType() {
    return findNotNullChildByClass(ZigContainerDeclType.class);
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
  public List<ZigLinkSection> getLinkSectionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigLinkSection.class);
  }

  @Override
  @NotNull
  public List<ZigParamDeclList> getParamDeclListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigParamDeclList.class);
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
  public List<ZigTypeExpr> getTypeExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigTypeExpr.class);
  }

  @Override
  @NotNull
  public List<ZigVarDecl> getVarDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigVarDecl.class);
  }

}
