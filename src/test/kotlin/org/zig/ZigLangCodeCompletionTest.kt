package org.zig

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.junit.Test
import org.zig.psi.ZigLangTypes

class ZigLangCodeCompletionTest: LightPlatformCodeInsightFixture4TestCase() {
  @Test
  fun testPub() {
    myFixture.configureByText(ZigFileType, "")
    myFixture.type("p")

    val l = myFixture.completeBasic()
    assertTrue(l.size == 1)
    assertEquals(l[0].lookupString, "${ZigLangTypes.PUB} ")
  }

  @Test
  fun testFun() {
    myFixture.configureByText(ZigFileType, "")
    myFixture.type("pub f")

    val l = myFixture.completeBasic()
    assertTrue(l.size == 1)
    assertEquals(l[0].lookupString, "${ZigLangTypes.FN} ")
  }

  @Test
  fun testImport() {
    myFixture.configureByText(ZigFileType, "")
    myFixture.type("const a = @imp")

    val l = myFixture.completeBasic()
    assertTrue(l.size == 2)
    assertEquals(l[0].lookupString, "import(")
  }

  @Test
  fun testFnReturnType() {
    myFixture.configureByText(ZigFileType, "")
    myFixture.type("fn main() i")

    val l = myFixture.completeBasic()
    assertTrue(l.size == 13)
  }

  @Test
  fun testRefStruct() {
    myFixture.configureByText(ZigFileType, "")

    myFixture.type("const Point = packed struct {a:i32}; const p = P")
    val l = myFixture.completeBasic()
    assertTrue(l[0].lookupString == "Point")
  }

  @Test
  fun testPackedStruct() {
    myFixture.configureByText(ZigFileType, "")

    myFixture.type("const Point = packed s")
    val l = myFixture.completeBasic()
    assertTrue(l[0].lookupString == "struct")
  }

  @Test
  fun testStruct() {
    myFixture.configureByText(ZigFileType, "")

    myFixture.type("const Point = s")
    val l = myFixture.completeBasic()
    assertTrue(l[0].lookupString == "struct")
  }

  @Test
  fun testPacked() {
    myFixture.configureByText(ZigFileType, "")

    myFixture.type("const Point = p")
    val l = myFixture.completeBasic()
    assertTrue(l[0].lookupString == "packed")
  }

  @Test
  fun testRefMemberFieldPrimitiveType() {
    myFixture.configureByText(ZigFileType, "")

    myFixture.type("const Point = struct {x:i3")
    val l = myFixture.completeBasic()
    assertTrue(l[0].lookupString == "i32")
  }


}