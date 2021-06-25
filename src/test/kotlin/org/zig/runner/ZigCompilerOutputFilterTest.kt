package org.zig.runner

import org.junit.Test

class ZigCompilerOutputFilterTest {

  @Test
  fun applyFilter() {
    val line = "./hello.zig:5090:512: error: expected token ';', found 'const'\n"
    val regex = "^(.*.zig):(\\d*):(\\d*):.*\n".toRegex()
    val result = regex.matchEntire(line)!!
    val g = result.groups[1]!!.value
    val gg = result.groups[2]!!.value
    val ggg = result.groups[3]!!.value

  }
}