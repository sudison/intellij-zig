package org.zig

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import junit.framework.TestCase
import org.junit.Test
import org.zig.psi.ZigLangTypes

class ZigLangCodeCompletionTest: LightPlatformCodeInsightFixture4TestCase() {
  @Test
  fun testPub() {
    myFixture.configureByText(ZigFileType, "")
    myFixture.type("p")

    val l = myFixture.completeBasic()
    assertTrue(l.size == 3)
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
    myFixture.type("fn main() i3")

    val l = myFixture.completeBasic()
    assertTrue(l[0].lookupString == "i32")
  }

  @Test
  fun testFnParaType() {
    myFixture.configureByText(ZigFileType, "")
    myFixture.type("fn main(x: i3")

    val l = myFixture.completeBasic()
    assertTrue(l[0].lookupString == "i32")
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
  fun testRefMemberFieldStruct() {
    myFixture.configureByText(ZigFileType, "")

    myFixture.type("const Bar = struct {x: i32}; const Point = struct {x:B")
    val l = myFixture.completeBasic()
    assertTrue(l[0].lookupString == "Bar")
  }

  @Test
  fun testNestedStruct() {
    myFixture.configureByText(ZigFileType, "")

    myFixture.type("const Bar = struct {x: i32, const Nested = struct {y: i32}; fn foo(x: i32) Bar;}; const a = Bar.")
    val l = myFixture.completeBasic()
    TestCase.assertTrue(l.size == 3)
    assertTrue(l.find{it.lookupString == "x"} != null)
    assertTrue(l.find{it.lookupString == "Nested"} != null)
    assertTrue(l.find{it.lookupString == "foo"} != null)
  }

  @Test
  fun testEnum() {
    myFixture.configureByText(ZigFileType, "")

    myFixture.type("const E = enum {one, two, pub fn foo() bool {}}; const e = E.")
    val l = myFixture.completeBasic()
    TestCase.assertTrue(l.size == 3)
    assertTrue(l.find{it.lookupString == "one"} != null)
    assertTrue(l.find{it.lookupString == "two"} != null)
    assertTrue(l.find{it.lookupString == "foo"} != null)

  }

  @Test
  fun testRefMemberFieldPrimitiveType() {
    myFixture.configureByText(ZigFileType, "")

    myFixture.type("const Point = struct {x: i3")
    val l = myFixture.completeBasic()
    assertTrue(l[0].lookupString == "i32")
  }

  @Test
  fun testStructRef() {
    myFixture.configureByText(ZigFileType, "")

    myFixture.type("const Foo = struct {foo:i32}; const Point = struct {x:i32, foo: Foo};  fn a() {const v = Point.f")
    val l = myFixture.completeBasic()
    assertTrue(l[0].lookupString == "foo")
  }

  @Test
  fun testStructRefField() {
    myFixture.configureByText(ZigFileType, "")

    myFixture.type("const Bar = struct {bar: i32}; const Foo = struct {foo:i32, b: Bar}; const Point = struct {x:i32, foo: Foo}; const p = Point{.x = 1}; fn a() {const v = p.foo.b.")
    val l = myFixture.completeBasic()
    assertTrue(l[0].lookupString == "bar")
  }

  @Test
  fun testStructFieldInit() {
    myFixture.configureByText(ZigFileType, "")

    myFixture.type("const Bar = struct {bar: i32};  fn a() {const b = Bar {.")
    val l = myFixture.completeBasic()
    assertTrue(l[0].lookupString == "bar")
  }


}