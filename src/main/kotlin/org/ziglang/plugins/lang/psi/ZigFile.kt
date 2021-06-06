package org.ziglang.plugins.lang.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import org.ziglang.plugins.lang.ZigFileType
import org.ziglang.plugins.lang.ZigLang

class ZigFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ZigLang) {
  override fun getFileType() = ZigFileType
  override fun processDeclarations(processor: PsiScopeProcessor, state: ResolveState, lastParent: PsiElement?, place: PsiElement): Boolean =
    children.all {
      ((it as? ZigGlobalVarDeclaration)?.variableDeclaration ?: it)
        .processDeclarations(processor, state, lastParent, place)
    }
}