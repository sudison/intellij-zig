// This is a generated file. Not intended for manual editing.
package org.ziglang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigPrimaryTypeExpr extends PsiElement {

  @Nullable
  ZigBuiltinidentifier getBuiltinidentifier();

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
  ZigTypeExpr getTypeExpr();

}
