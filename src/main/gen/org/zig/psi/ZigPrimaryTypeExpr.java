// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigPrimaryTypeExpr extends PsiElement {

  @Nullable
  ZigByteAlign getByteAlign();

  @Nullable
  ZigCallConv getCallConv();

  @Nullable
  ZigContainerDecl getContainerDecl();

  @Nullable
  ZigErrorSetDecl getErrorSetDecl();

  @Nullable
  ZigFnCallArguments getFnCallArguments();

  @Nullable
  ZigGroupedExpr getGroupedExpr();

  @Nullable
  ZigIfTypeExpr getIfTypeExpr();

  @Nullable
  ZigInitList getInitList();

  @Nullable
  ZigLabeledTypeExpr getLabeledTypeExpr();

  @Nullable
  ZigLinkSection getLinkSection();

  @Nullable
  ZigParamDeclList getParamDeclList();

  @Nullable
  ZigStringliteral getStringliteral();

  @Nullable
  ZigSwitchExpr getSwitchExpr();

  @Nullable
  ZigTypeExpr getTypeExpr();

}
