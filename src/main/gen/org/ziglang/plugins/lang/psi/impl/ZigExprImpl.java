// This is a generated file. Not intended for manual editing.
package org.ziglang.plugins.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.ziglang.plugins.lang.psi.ZigTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.ziglang.plugins.lang.psi.*;

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
  @Nullable
  public ZigAdditionExpr getAdditionExpr() {
    return findChildByClass(ZigAdditionExpr.class);
  }

  @Override
  @Nullable
  public ZigAsmExpr getAsmExpr() {
    return findChildByClass(ZigAsmExpr.class);
  }

  @Override
  @Nullable
  public ZigAssignExpr getAssignExpr() {
    return findChildByClass(ZigAssignExpr.class);
  }

  @Override
  @Nullable
  public ZigAsyncExpr getAsyncExpr() {
    return findChildByClass(ZigAsyncExpr.class);
  }

  @Override
  @Nullable
  public ZigAwaitExpr getAwaitExpr() {
    return findChildByClass(ZigAwaitExpr.class);
  }

  @Override
  @Nullable
  public ZigBinaryAndExpr getBinaryAndExpr() {
    return findChildByClass(ZigBinaryAndExpr.class);
  }

  @Override
  @Nullable
  public ZigBinaryOrExpr getBinaryOrExpr() {
    return findChildByClass(ZigBinaryOrExpr.class);
  }

  @Override
  @Nullable
  public ZigBinaryXorExpr getBinaryXorExpr() {
    return findChildByClass(ZigBinaryXorExpr.class);
  }

  @Override
  @Nullable
  public ZigBitShiftExpr getBitShiftExpr() {
    return findChildByClass(ZigBitShiftExpr.class);
  }

  @Override
  @Nullable
  public ZigBlockExpr getBlockExpr() {
    return findChildByClass(ZigBlockExpr.class);
  }

  @Override
  @Nullable
  public ZigBoolAndExpr getBoolAndExpr() {
    return findChildByClass(ZigBoolAndExpr.class);
  }

  @Override
  @Nullable
  public ZigBoolOrExpr getBoolOrExpr() {
    return findChildByClass(ZigBoolOrExpr.class);
  }

  @Override
  @Nullable
  public ZigBreakExpr getBreakExpr() {
    return findChildByClass(ZigBreakExpr.class);
  }

  @Override
  @Nullable
  public ZigCancelExpr getCancelExpr() {
    return findChildByClass(ZigCancelExpr.class);
  }

  @Override
  @Nullable
  public ZigComparisonExpr getComparisonExpr() {
    return findChildByClass(ZigComparisonExpr.class);
  }

  @Override
  @Nullable
  public ZigContainerExpr getContainerExpr() {
    return findChildByClass(ZigContainerExpr.class);
  }

  @Override
  @Nullable
  public ZigContinueExpr getContinueExpr() {
    return findChildByClass(ZigContinueExpr.class);
  }

  @Override
  @Nullable
  public ZigCurlySuffixExpr getCurlySuffixExpr() {
    return findChildByClass(ZigCurlySuffixExpr.class);
  }

  @Override
  @Nullable
  public ZigExpr getExpr() {
    return findChildByClass(ZigExpr.class);
  }

  @Override
  @Nullable
  public ZigGroupedExpr getGroupedExpr() {
    return findChildByClass(ZigGroupedExpr.class);
  }

  @Override
  @Nullable
  public ZigMacroExpr getMacroExpr() {
    return findChildByClass(ZigMacroExpr.class);
  }

  @Override
  @Nullable
  public ZigMultiplyExpr getMultiplyExpr() {
    return findChildByClass(ZigMultiplyExpr.class);
  }

  @Override
  @Nullable
  public ZigOrElseExpr getOrElseExpr() {
    return findChildByClass(ZigOrElseExpr.class);
  }

  @Override
  @Nullable
  public ZigPrefixOpExpr getPrefixOpExpr() {
    return findChildByClass(ZigPrefixOpExpr.class);
  }

  @Override
  @Nullable
  public ZigResumeExpr getResumeExpr() {
    return findChildByClass(ZigResumeExpr.class);
  }

  @Override
  @Nullable
  public ZigReturnExpr getReturnExpr() {
    return findChildByClass(ZigReturnExpr.class);
  }

  @Override
  @Nullable
  public ZigSuffixOpExpr getSuffixOpExpr() {
    return findChildByClass(ZigSuffixOpExpr.class);
  }

  @Override
  @Nullable
  public ZigTryExpr getTryExpr() {
    return findChildByClass(ZigTryExpr.class);
  }

  @Override
  @Nullable
  public ZigTypeExpr getTypeExpr() {
    return findChildByClass(ZigTypeExpr.class);
  }

  @Override
  @Nullable
  public ZigUnwrapExpr getUnwrapExpr() {
    return findChildByClass(ZigUnwrapExpr.class);
  }

}
