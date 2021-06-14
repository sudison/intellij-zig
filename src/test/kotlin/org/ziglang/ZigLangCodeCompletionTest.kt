package org.ziglang

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.junit.Assert
import org.junit.Test

class ZigLangCodeCompletionTest: LightPlatformCodeInsightFixture4TestCase() {
  @Test
  fun testA() {
    myFixture.configureByText(ZigFileType, "")
    myFixture.type("p")

    Assert.assertEquals(1, myFixture.completeBasic().size)
  }


}