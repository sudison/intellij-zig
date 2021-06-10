package org.ziglang.plugins.lang

import com.intellij.testFramework.ParsingTestCase
import org.ziglang.ZigFileType
import org.ziglang.ZigParserDefinition

class ZigParserTests : ParsingTestCase("", ZigFileType.defaultExtension, ZigParserDefinition()) {
  override fun getTestDataPath() = "src/testdata/parsing"
  override fun skipSpaces() = true

  fun testComments() {
    println(name)
    val text = loadFile("$testName.$myFileExt")
    myFile = createPsiFile(testName, text)
    ensureParsed(myFile)
    println(toParseTreeText(myFile, skipSpaces(), includeRanges()))

  }

  fun testFunctionCall() {
    println(name)
    doTest(false, true)
  }
}