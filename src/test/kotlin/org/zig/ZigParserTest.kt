package org.zig.plugins.lang

import com.intellij.testFramework.ParsingTestCase
import org.junit.Test
import org.zig.ZigFileType
import org.zig.ZigParserDefinition

class ZigParserTests : ParsingTestCase("", ZigFileType.defaultExtension, ZigParserDefinition()) {
  override fun getTestDataPath() = "src/testdata/parsing"
  override fun skipSpaces() = true

  private fun printTree() {
    println(name)
    val text = loadFile("$testName.$myFileExt")
    myFile = createPsiFile(testName, text)
    ensureParsed(myFile)
    println(toParseTreeText(myFile, skipSpaces(), includeRanges()))
  }
  @Test
  fun testComments() {
   printTree()
  }

  @Test
  fun testFunctionCall() {
    printTree()

  }
}