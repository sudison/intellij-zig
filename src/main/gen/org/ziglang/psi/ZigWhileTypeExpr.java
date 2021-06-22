// This is a generated file. Not intended for manual editing.
package org.ziglang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigWhileTypeExpr extends PsiElement {

  @Nullable
  ZigPayload getPayload();

  @NotNull
  List<ZigTypeExpr> getTypeExprList();

  @NotNull
  ZigWhilePrefix getWhilePrefix();

}
