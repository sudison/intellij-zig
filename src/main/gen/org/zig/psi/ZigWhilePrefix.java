// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigWhilePrefix extends PsiElement {

  @NotNull
  ZigExpr getExpr();

  @Nullable
  ZigPtrPayload getPtrPayload();

  @Nullable
  ZigWhileContinueExpr getWhileContinueExpr();

}
