// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigStatement extends PsiElement {

  @Nullable
  ZigAssignExpr getAssignExpr();

  @Nullable
  ZigBlockExprStatement getBlockExprStatement();

  @Nullable
  ZigIfStatement getIfStatement();

  @Nullable
  ZigLabeledStatement getLabeledStatement();

  @Nullable
  ZigPayload getPayload();

  @Nullable
  ZigSwitchExpr getSwitchExpr();

  @Nullable
  ZigVarDecl getVarDecl();

}
