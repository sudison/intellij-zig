// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigContainerDeclAuto extends PsiElement {

  @NotNull
  ZigContainerDeclType getContainerDeclType();

  @NotNull
  List<ZigContainerField> getContainerFieldList();

  @NotNull
  List<ZigExpr> getExprList();

  @NotNull
  List<ZigFnDecl> getFnDeclList();

  @NotNull
  List<ZigTestDecl> getTestDeclList();

  @NotNull
  List<ZigTopLevelComptime> getTopLevelComptimeList();

  @NotNull
  List<ZigVarDecl> getVarDeclList();

}
