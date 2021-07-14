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

public class ZigExprImpl extends ASTWrapperPsiElement implements ZigExpr {

  public ZigExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ZigAdditionOp> getAdditionOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigAdditionOp.class);
  }

  @Override
  @NotNull
  public List<ZigAsmExpr> getAsmExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigAsmExpr.class);
  }

  @Override
  @NotNull
  public List<ZigBitShiftOp> getBitShiftOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigBitShiftOp.class);
  }

  @Override
  @NotNull
  public List<ZigBlock> getBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigBlock.class);
  }

  @Override
  @NotNull
  public List<ZigBlockLabel> getBlockLabelList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigBlockLabel.class);
  }

  @Override
  @NotNull
  public List<ZigBreakLabel> getBreakLabelList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigBreakLabel.class);
  }

  @Override
  @NotNull
  public List<ZigExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigExpr.class);
  }

  @Override
  @NotNull
  public List<ZigFnCallArguments> getFnCallArgumentsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigFnCallArguments.class);
  }

  @Override
  @NotNull
  public List<ZigIfExpr> getIfExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigIfExpr.class);
  }

  @Override
  @NotNull
  public List<ZigInitList> getInitListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigInitList.class);
  }

  @Override
  @NotNull
  public List<ZigLoopExpr> getLoopExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigLoopExpr.class);
  }

  @Override
  @NotNull
  public List<ZigMultiplyOp> getMultiplyOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigMultiplyOp.class);
  }

  @Override
  @NotNull
  public List<ZigPayload> getPayloadList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigPayload.class);
  }

  @Override
  @NotNull
  public List<ZigPrefixOp> getPrefixOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigPrefixOp.class);
  }

  @Override
  @NotNull
  public List<ZigPrefixTypeOp> getPrefixTypeOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigPrefixTypeOp.class);
  }

  @Override
  @NotNull
  public List<ZigPrimaryTypeExpr> getPrimaryTypeExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigPrimaryTypeExpr.class);
  }

  @Override
  @NotNull
  public List<ZigSuffixOp> getSuffixOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigSuffixOp.class);
  }

}
