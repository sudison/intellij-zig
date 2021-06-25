// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigWhileStatement extends PsiElement {

  @Nullable
  ZigAssignExpr getAssignExpr();

  @Nullable
  ZigBlockExpr getBlockExpr();

  @Nullable
  ZigPayload getPayload();

  @Nullable
  ZigStatement getStatement();

  @NotNull
  ZigWhilePrefix getWhilePrefix();

}
