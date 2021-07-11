// This is a generated file. Not intended for manual editing.
package org.zig.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.zig.psi.ZigLangTypes.*;
import org.zig.reference.ZigFnMixin;
import org.zig.psi.*;

public class ZigFnDeclImpl extends ZigFnMixin implements ZigFnDecl {

  public ZigFnDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZigVisitor visitor) {
    visitor.visitFnDecl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZigVisitor) accept((ZigVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ZigBlock getBlock() {
    return findChildByClass(ZigBlock.class);
  }

  @Override
  @NotNull
  public ZigFnProto getFnProto() {
    return findNotNullChildByClass(ZigFnProto.class);
  }

}
