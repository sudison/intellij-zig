// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigSuffixExpr extends PsiElement {

  @NotNull
  List<ZigFnCallArguments> getFnCallArgumentsList();

  @NotNull
  ZigPrimaryTypeExpr getPrimaryTypeExpr();

  @NotNull
  List<ZigSuffixOp> getSuffixOpList();

}
