package org.zig.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import org.zig.ZigFileType
import org.zig.ZigLang

class ZigFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ZigLang) {
  override fun getFileType() = ZigFileType
}