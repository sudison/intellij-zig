// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigPrimaryExpr extends PsiElement {

  @Nullable
  ZigAsmExpr getAsmExpr();

  @Nullable
  ZigBlock getBlock();

  @Nullable
  ZigBlockLabel getBlockLabel();

  @Nullable
  ZigBreakLabel getBreakLabel();

  @Nullable
  ZigCurlySuffixExpr getCurlySuffixExpr();

  @Nullable
  ZigExpr getExpr();

  @Nullable
  ZigIfExpr getIfExpr();

  @Nullable
  ZigLoopExpr getLoopExpr();

}
