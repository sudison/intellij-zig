package org.zig.psi

import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import org.zig.ZigLang

open class ZigLangTokenType(debugName: String) : IElementType(debugName, ZigLang) {
  companion object TokenHolder {

    @JvmField
    val COMMENTS = TokenSet.create(ZigLangTypes.COMMENT)
    @JvmField
    val STRINGS = TokenSet.create(ZigLangTypes.STRINGLITERAL)
  }
}