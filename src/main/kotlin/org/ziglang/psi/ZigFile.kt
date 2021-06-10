package org.ziglang.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import org.ziglang.ZigFileType
import org.ziglang.ZigLang

class ZigFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ZigLang) {
  override fun getFileType() = ZigFileType
}