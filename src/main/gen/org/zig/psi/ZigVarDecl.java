// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigVarDecl extends PsiElement {

  @Nullable
  ZigByteAlign getByteAlign();

  @Nullable
  ZigEqualExpr getEqualExpr();

  @NotNull
  List<ZigFnCallArguments> getFnCallArgumentsList();

  @Nullable
  ZigLinkSection getLinkSection();

  @NotNull
  List<ZigPrefixTypeOp> getPrefixTypeOpList();

  @NotNull
  List<ZigPrimaryTypeExpr> getPrimaryTypeExprList();

  @NotNull
  List<ZigSuffixOp> getSuffixOpList();

}
