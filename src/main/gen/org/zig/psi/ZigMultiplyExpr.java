// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigMultiplyExpr extends PsiElement {

  @NotNull
  List<ZigAsmExpr> getAsmExprList();

  @NotNull
  List<ZigBlock> getBlockList();

  @NotNull
  List<ZigBlockLabel> getBlockLabelList();

  @NotNull
  List<ZigBreakLabel> getBreakLabelList();

  @NotNull
  List<ZigExpr> getExprList();

  @NotNull
  List<ZigFnCallArguments> getFnCallArgumentsList();

  @NotNull
  List<ZigIfExpr> getIfExprList();

  @NotNull
  List<ZigInitList> getInitListList();

  @NotNull
  List<ZigLoopExpr> getLoopExprList();

  @NotNull
  List<ZigMultiplyOp> getMultiplyOpList();

  @NotNull
  List<ZigPrefixOp> getPrefixOpList();

  @NotNull
  List<ZigPrefixTypeOp> getPrefixTypeOpList();

  @NotNull
  List<ZigPrimaryTypeExpr> getPrimaryTypeExprList();

  @NotNull
  List<ZigSuffixOp> getSuffixOpList();

}
