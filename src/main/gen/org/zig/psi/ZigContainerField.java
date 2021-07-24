// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;

public interface ZigContainerField extends PsiNameIdentifierOwner {

  @Nullable
  ZigByteAlign getByteAlign();

  @Nullable
  ZigExpr getExpr();

  @NotNull
  List<ZigFnCallArguments> getFnCallArgumentsList();

  @NotNull
  List<ZigPrefixTypeOp> getPrefixTypeOpList();

  @NotNull
  List<ZigPrimaryTypeExpr> getPrimaryTypeExprList();

  @NotNull
  List<ZigSuffixOp> getSuffixOpList();

}
