// This is a generated file. Not intended for manual editing.
package org.ziglang.plugins.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;

public interface ZigVariableDeclaration extends PsiNameIdentifierOwner {

  @Nullable
  ZigAsmExpr getAsmExpr();

  @Nullable
  ZigBlockExpr getBlockExpr();

  @Nullable
  ZigContainerExpr getContainerExpr();

  @Nullable
  ZigContinueExpr getContinueExpr();

  @NotNull
  List<ZigExpr> getExprList();

  @Nullable
  ZigGroupedExpr getGroupedExpr();

  @Nullable
  ZigMacroExpr getMacroExpr();

  @Nullable
  ZigTypeExpr getTypeExpr();

}
