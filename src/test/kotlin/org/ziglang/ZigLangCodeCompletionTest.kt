package org.ziglang

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.junit.Test
import org.ziglang.psi.ZigLangTypes

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
}