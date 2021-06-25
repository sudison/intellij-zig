// This is a generated file. Not intended for manual editing.
package org.zig.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.zig.psi.ZigLangTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.zig.psi.*;

public class ZigSwitchProngImpl extends ASTWrapperPsiElement implements ZigSwitchProng {

  public ZigSwitchProngImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitSwitchProng(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ZigAssignExpr getAssignExpr() {
    return findNotNullChildByClass(ZigAssignExpr.class);
  }

  @Override
  @Nullable
  public ZigPtrPayload getPtrPayload() {
    return findChildByClass(ZigPtrPayload.class);
  }

  @Override
  @NotNull
  public ZigSwitchCase getSwitchCase() {
    return findNotNullChildByClass(ZigSwitchCase.class);
  }

}
