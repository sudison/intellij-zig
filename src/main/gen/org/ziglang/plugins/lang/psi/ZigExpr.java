// This is a generated file. Not intended for manual editing.
package org.ziglang.plugins.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigExpr extends PsiElement {

  @Nullable
  ZigAdditionExpr getAdditionExpr();

  @Nullable
  ZigAsmExpr getAsmExpr();

  @Nullable
  ZigAssignExpr getAssignExpr();

  @Nullable
  ZigAsyncExpr getAsyncExpr();

  @Nullable
  ZigAwaitExpr getAwaitExpr();

  @Nullable
  ZigBinaryAndExpr getBinaryAndExpr();

  @Nullable
  ZigBinaryOrExpr getBinaryOrExpr();

  @Nullable
  ZigBinaryXorExpr getBinaryXorExpr();

  @Nullable
  ZigBitShiftExpr getBitShiftExpr();

  @Nullable
  ZigBlockExpr getBlockExpr();

  @Nullable
  ZigBoolAndExpr getBoolAndExpr();

  @Nullable
  ZigBoolOrExpr getBoolOrExpr();

  @Nullable
  ZigBreakExpr getBreakExpr();

  @Nullable
  ZigCancelExpr getCancelExpr();

  @Nullable
  ZigComparisonExpr getComparisonExpr();

  @Nullable
  ZigContainerExpr getContainerExpr();

  @Nullable
  ZigContinueExpr getContinueExpr();

  @Nullable
  ZigCurlySuffixExpr getCurlySuffixExpr();

  @Nullable
  ZigExpr getExpr();

  @Nullable
  ZigGroupedExpr getGroupedExpr();

  @Nullable
  ZigMacroExpr getMacroExpr();

  @Nullable
  ZigMultiplyExpr getMultiplyExpr();

  @Nullable
  ZigOrElseExpr getOrElseExpr();

  @Nullable
  ZigPrefixOpExpr getPrefixOpExpr();

  @Nullable
  ZigResumeExpr getResumeExpr();

  @Nullable
  ZigReturnExpr getReturnExpr();

  @Nullable
  ZigSuffixOpExpr getSuffixOpExpr();

  @Nullable
  ZigTryExpr getTryExpr();

  @Nullable
  ZigTypeExpr getTypeExpr();

  @Nullable
  ZigUnwrapExpr getUnwrapExpr();

}
