package org.ziglang.plugins.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon


object ZigFileType : LanguageFileType(ZigLang) {
  override fun getName(): String {
    return "ZigLang"
  }

  override fun getDescription(): String {
    return "ZigLang files"
  }

  override fun getDefaultExtension(): String {
    return "zig"
  }

  override fun getIcon(): Icon {
    return ZigIcons.icon
  }
}