package org.zig

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType
import org.zig.psi.ZigLangTypes

object ZigLangSyntaxHighlighter: SyntaxHighlighterBase() {
  private val KEYWORDS = listOf(
    ZigLangTypes.PUB,
    ZigLangTypes.CONST,
    ZigLangTypes.FN,
    ZigLangTypes.TEST,
    ZigLangTypes.RETURN,
    ZigLangTypes.ALIGN,
    ZigLangTypes.ALLOWZERO,
    ZigLangTypes.AND,
    ZigLangTypes.ANYFRAME,
    ZigLangTypes.ANY_TYPE,
    ZigLangTypes.ASM,
    ZigLangTypes.ASYNC,
    ZigLangTypes.AWAIT,
    ZigLangTypes.BREAK,
    ZigLangTypes.CALLCONV,
    ZigLangTypes.CATCH,
    ZigLangTypes.COMPTIME,
    ZigLangTypes.CONTINUE,
    ZigLangTypes.DEFER,
    ZigLangTypes.ELSE,
    ZigLangTypes.ENUM,
    ZigLangTypes.ERRDEFER,
    ZigLangTypes.ERROR,
    ZigLangTypes.EXPORT,
    ZigLangTypes.EXTERN,
    ZigLangTypes.FALSE,
    ZigLangTypes.FOR,
    ZigLangTypes.IF,
    ZigLangTypes.INLINE,
    ZigLangTypes.NOALIAS,
    ZigLangTypes.NOSUSPEND,
    ZigLangTypes.NOINLINE,
    ZigLangTypes.NULL,
    ZigLangTypes.OPAQUE,
    ZigLangTypes.OR,
    ZigLangTypes.ORELSE,
    ZigLangTypes.PACKED,
    ZigLangTypes.RESUME,
    ZigLangTypes.LINKSECTION,
    ZigLangTypes.STRUCT,
    ZigLangTypes.SUSPEND,
    ZigLangTypes.SWITCH,
    ZigLangTypes.THREAD_LOCAL,
    ZigLangTypes.TRUE,
    ZigLangTypes.TRY,
    ZigLangTypes.UNDEFINED,
    ZigLangTypes.UNION,
    ZigLangTypes.UNREACHABLE,
    ZigLangTypes.USING_NAME_SPACE,
    ZigLangTypes.VAR,
    ZigLangTypes.VOLATILE,
    ZigLangTypes.WHILE
  )
  private val KEYWORD = arrayOf(TextAttributesKey.createTextAttributesKey("ZIGLANG_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD))
  private val builtInFunctions =
    arrayOf(TextAttributesKey.createTextAttributesKey("ZIGLANG_BUILTIN_FUNCTIONS", DefaultLanguageHighlighterColors.STATIC_METHOD))

  override fun getHighlightingLexer(): Lexer = ZigLexerAdapter()

  override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
    when (tokenType) {
      in KEYWORDS -> KEYWORD
      ZigLangTypes.BUILTINIDENTIFIER -> builtInFunctions
      else -> emptyArray()
    }
  }

class ZigLangSyntaxHighlighterFactory: SyntaxHighlighterFactory() {
  override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
    return ZigLangSyntaxHighlighter
  }
}