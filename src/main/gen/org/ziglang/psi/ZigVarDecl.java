// This is a generated file. Not intended for manual editing.
package org.ziglang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigVarDecl extends PsiElement {

  @Nullable
  ZigByteAlign getByteAlign();

  @Nullable
  ZigExpr getExpr();

  @Nullable
  ZigLinkSection getLinkSection();

  @Nullable
  ZigTypeExpr getTypeExpr();

  @NotNull
  PsiElement getId();

}
