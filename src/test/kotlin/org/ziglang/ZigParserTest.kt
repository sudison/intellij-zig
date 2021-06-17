package org.ziglang.plugins.lang

import com.intellij.testFramework.ParsingTestCase
import org.junit.Test
import org.ziglang.ZigFileType
import org.ziglang.ZigParserDefinition

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