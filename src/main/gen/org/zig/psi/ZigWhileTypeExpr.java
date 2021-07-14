// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigWhileTypeExpr extends PsiElement {

  @NotNull
  List<ZigFnCallArguments> getFnCallArgumentsList();

  @Nullable
  ZigPayload getPayload();

  @NotNull
  List<ZigPrefixTypeOp> getPrefixTypeOpList();

  @NotNull
  List<ZigPrimaryTypeExpr> getPrimaryTypeExprList();

  @NotNull
  List<ZigSuffixOp> getSuffixOpList();

  @NotNull
  ZigWhilePrefix getWhilePrefix();

}
