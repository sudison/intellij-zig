// This is a generated file. Not intended for manual editing.
package org.ziglang.plugins.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigAsyncExpr extends PsiElement {

  @NotNull
  List<ZigAsmExpr> getAsmExprList();

  @NotNull
  List<ZigBlockExpr> getBlockExprList();

  @NotNull
  List<ZigContainerExpr> getContainerExprList();

  @NotNull
  List<ZigContinueExpr> getContinueExprList();

  @NotNull
  List<ZigExpr> getExprList();

  @NotNull
  ZigFnCallSuffix getFnCallSuffix();

  @NotNull
  List<ZigGroupedExpr> getGroupedExprList();

  @NotNull
  List<ZigMacroExpr> getMacroExprList();

}
