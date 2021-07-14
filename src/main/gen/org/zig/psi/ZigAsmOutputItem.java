// This is a generated file. Not intended for manual editing.
package org.zig.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZigAsmOutputItem extends PsiElement {

  @NotNull
  List<ZigFnCallArguments> getFnCallArgumentsList();

  @NotNull
  List<ZigPrefixTypeOp> getPrefixTypeOpList();

  @Nullable
  ZigPrimaryTypeExpr getPrimaryTypeExpr();

  @NotNull
  ZigStringliteral getStringliteral();

  @NotNull
  List<ZigSuffixOp> getSuffixOpList();

}
