// This is a generated file. Not intended for manual editing.
package org.ziglang.plugins.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.ziglang.plugins.lang.psi.ZigTypes.*;
import org.ziglang.plugins.lang.ZigBlockMixin;
import org.ziglang.plugins.lang.psi.*;

public class ZigBlockImpl extends ZigBlockMixin implements ZigBlock {

  public ZigBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ZigStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZigStatement.class);
  }

  @Override
  @Nullable
  public ZigSymbol getSymbol() {
    return findChildByClass(ZigSymbol.class);
  }

}
