// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigPrefixTypeOp extends PsiElement {

  @Nullable
  ZigArrayTypeStart getArrayTypeStart();

  @NotNull
  List<ZigByteAlign> getByteAlignList();

  @NotNull
  List<ZigExpr> getExprList();

  @Nullable
  ZigPtrTypeStart getPtrTypeStart();

  @Nullable
  ZigSliceTypeStart getSliceTypeStart();

}
