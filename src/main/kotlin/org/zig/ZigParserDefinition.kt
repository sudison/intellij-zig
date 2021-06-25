package org.zig

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lexer.FlexAdapter
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.zig.parser.ZigLangLexer
import org.zig.psi.ZigFile
import org.zig.psi.ZigLangTokenType
import org.zig.psi.ZigLangTypes
import org.zig.psi.parser.ZigLangParser

class ZigLexerAdapter : FlexAdapter(ZigLangLexer())

class ZigParserDefinition : ParserDefinition {
  override fun createParser(project: Project?) = ZigLangParser()
  override fun createLexer(project: Project?) = ZigLexerAdapter()
  override fun createFile(viewProvider: FileViewProvider) = ZigFile(viewProvider)
  override fun createElement(node: ASTNode?) = ZigLangTypes.Factory.createElement(node)
  override fun getStringLiteralElements() = ZigLangTokenType.STRINGS
  override fun getCommentTokens() = ZigLangTokenType.COMMENTS
  override fun getFileNodeType() = FILE
  override fun getWhitespaceTokens() = TokenSet.WHITE_SPACE
  override fun spaceExistanceTypeBetweenTokens(left: ASTNode?, right: ASTNode?) =
    ParserDefinition.SpaceRequirements.MAY

  private companion object FileHolder {
    private val FILE = IFileElementType(ZigLang)
  }
}