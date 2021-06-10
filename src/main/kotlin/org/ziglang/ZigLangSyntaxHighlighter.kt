package org.ziglang

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType
import org.ziglang.psi.ZigLangTypes

object ZigLangSyntaxHighlighter: SyntaxHighlighterBase() {
  val KEYWORDS = listOf(ZigLangTypes.PUB, ZigLangTypes.CONST, ZigLangTypes.FN, ZigLangTypes.RETURN)
  val KEYWORD = TextAttributesKey.createTextAttributesKey("ZIGLANG_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)

  override fun getHighlightingLexer(): Lexer = ZigLexerAdapter()

  override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
    when (tokenType) {
      in KEYWORDS -> arrayOf(KEYWORD)
      else -> emptyArray()
    }
  }

class ZigLangSyntaxHighlighterFactory: SyntaxHighlighterFactory() {
  override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
    return ZigLangSyntaxHighlighter
  }
}