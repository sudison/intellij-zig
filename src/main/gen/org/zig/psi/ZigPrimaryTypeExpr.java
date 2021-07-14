// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigPrimaryTypeExpr extends PsiElement {

  @Nullable
  ZigContainerDecl getContainerDecl();

  @Nullable
  ZigErrorSetDecl getErrorSetDecl();

  @Nullable
  ZigFnCallArguments getFnCallArguments();

  @Nullable
  ZigFnProto getFnProto();

  @Nullable
  ZigGroupedExpr getGroupedExpr();

  @Nullable
  ZigIfTypeExpr getIfTypeExpr();

  @Nullable
  ZigInitList getInitList();

  @Nullable
  ZigLabeledTypeExpr getLabeledTypeExpr();

  @NotNull
  List<ZigPrefixTypeOp> getPrefixTypeOpList();

  @NotNull
  List<ZigPrimaryTypeExpr> getPrimaryTypeExprList();

  @Nullable
  ZigStringliteral getStringliteral();

  @NotNull
  List<ZigSuffixOp> getSuffixOpList();

  @Nullable
  ZigSwitchExpr getSwitchExpr();

  @Nullable
  ZigSymbol getSymbol();

}
