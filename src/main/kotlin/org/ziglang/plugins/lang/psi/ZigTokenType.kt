package org.ziglang.plugins.lang.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import org.ziglang.plugins.lang.ZigLang

open class ZigTokenType(debugName: String) : IElementType(debugName, ZigLang) {
  companion object TokenHolder {
    @JvmField val LINE_COMMENT = ZigTokenType("comment")
    @JvmField val COMMENTS = TokenSet.create(LINE_COMMENT)
    @JvmField val STRINGS = TokenSet.create(ZigTypes.STR)
    @JvmField val IDENTIFIERS = TokenSet.create(ZigTypes.SYM, ZigTypes.SYMBOL)

    fun fromText(string: String, project: Project) = PsiFileFactory
      .getInstance(project)
      .createFileFromText(ZigLang, string)
      .firstChild
      .let { (it as? PsiErrorElement)?.firstChild ?: it }
  }
}