// This is a generated file. Not intended for manual editing.
package org.ziglang.plugins.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigSuffixOpExpr extends PsiElement {

  @Nullable
  ZigArrayAccessSuffix getArrayAccessSuffix();

  @NotNull
  ZigExpr getExpr();

  @Nullable
  ZigFieldAccessSuffix getFieldAccessSuffix();

  @Nullable
  ZigFnCallSuffix getFnCallSuffix();

  @Nullable
  ZigOptionalSuffix getOptionalSuffix();

  @Nullable
  ZigPointerSuffix getPointerSuffix();

  @Nullable
  ZigSliceSuffix getSliceSuffix();

}
