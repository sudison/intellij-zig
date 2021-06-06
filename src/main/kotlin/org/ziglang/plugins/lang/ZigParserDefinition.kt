package org.ziglang.plugins.lang

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lexer.FlexAdapter
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.ziglang.plugins.lang.psi.ZigFile
import org.ziglang.plugins.lang.psi.ZigTokenType
import org.ziglang.plugins.lang.psi.ZigTypes
import org.ziglang.plugins.lang.psi.parser.ZigParser

class ZigLexerAdapter : FlexAdapter(ZigLexer())

class ZigParserDefinition : ParserDefinition {
  override fun createParser(project: Project?) = ZigParser()
  override fun createLexer(project: Project?) = ZigLexerAdapter()
  override fun createFile(viewProvider: FileViewProvider) = ZigFile(viewProvider)
  override fun createElement(node: ASTNode?) = ZigTypes.Factory.createElement(node)
  override fun getStringLiteralElements() = ZigTokenType.STRINGS
  override fun getCommentTokens() = ZigTokenType.COMMENTS
  override fun getFileNodeType() = FILE
  override fun getWhitespaceTokens() = TokenSet.WHITE_SPACE
  override fun spaceExistanceTypeBetweenTokens(left: ASTNode?, right: ASTNode?) =
    ParserDefinition.SpaceRequirements.MAY

  private companion object FileHolder {
    private val FILE = IFileElementType(ZigLang)
  }
}