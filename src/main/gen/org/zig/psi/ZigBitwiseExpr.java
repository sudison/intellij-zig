// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigBitwiseExpr extends PsiElement {

  @NotNull
  List<ZigBitShiftExpr> getBitShiftExprList();

  @NotNull
  List<ZigBitwiseOp> getBitwiseOpList();

}
