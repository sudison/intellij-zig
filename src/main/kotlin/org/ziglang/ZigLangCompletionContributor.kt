package org.ziglang

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.util.ProcessingContext
import org.ziglang.psi.ZigFile
import org.ziglang.psi.ZigLangTypes


class ZigCompletionProvider(private val les: List<LookupElement>) : CompletionProvider<CompletionParameters>() {
  override fun addCompletions(
    parameters: CompletionParameters,
    context: ProcessingContext,
    result: CompletionResultSet
  ) {
    les.forEach(result::addElement)
  }
}

class ZigLangCompletionContributor : CompletionContributor() {

  private val topKeyWords = listOf(
    ZigLangTypes.CONST,
    ZigLangTypes.VAR,
    ZigLangTypes.FN,
    ZigLangTypes.PUB,
    ZigLangTypes.EXPORT,
    ZigLangTypes.EXTERN,
    ZigLangTypes.INLINE,
    ZigLangTypes.NOINLINE,
    ZigLangTypes.THREAD_LOCAL,
    ZigLangTypes.USING_NAME_SPACE
  ).map {
    LookupElementBuilder
      .create("$it ")
      .withPresentableText(it.toString())
      .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
  }

  private val builtInFunctions = listOf(
    "addWithOverflow",
    "alignCast",
    "alignOf",
    "as",
    "asyncCall",
    "atomicLoad",
    "atomicRmw",
    "atomicStore",
    "bitCast",
    "bitOffsetOf",
    "boolToInt",
    "bitSizeOf",
    "breakpoint",
    "mulAdd",
    "byteSwap",
    "bitReverse",
    "offsetOf",
    "call",
    "cDefine",
    "cImport",
    "cInclude",
    "clz",
    "cmpxchgStrong",
    "cmpxchgWeak",
    "compileError",
    "compileLog",
    "ctz",
    "cUndef",
    "divExact",
    "divFloor",
    "divTrunc",
    "embedFile",
    "enumToInt",
    "errorName",
    "errorReturnTrace",
    "errorToInt",
    "errSetCast",
    "export",
    "extern",
    "fence",
    "field",
    "fieldParentPtr",
    "floatCast",
    "floatToInt",
    "frame",
    "Frame",
    "frameAddress",
    "frameSize",
    "hasDecl",
    "hasField",
    "import",
    "intCast",
    "intToEnum",
    "intToError",
    "intToFloat",
    "intToPtr",
    "memcpy",
    "memset",
    "wasmMemorySize",
    "wasmMemoryGrow",
    "mod",
    "mulWithOverflow",
    "panic",
    "popCount",
    "ptrCast",
    "ptrToInt",
    "rem",
    "returnAddress",
    "setAlignStack",
    "setCold",
    "setEvalBranchQuota",
    "setFloatMode",
    "setRuntimeSafety",
    "shlExact",
    "shlWithOverflow",
    "shrExact",
    "shuffle",
    "sizeOf",
    "splat",
    "reduce",
    "src",
    "sqrt",
    "sin",
    "cos",
    "exp",
    "exp2",
    "log",
    "log2",
    "log10",
    "fabs",
    "floor",
    "ceil",
    "trunc",
    "round",
    "subWithOverflow",
    "tagName",
    "This",
    "truncate",
    "Type",
    "typeInfo",
    "typeName",
    "TypeOf",
    "unionInit",

  ).map {
    LookupElementBuilder
      .create("$it(\"")
      .withPresentableText(it)
      .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
  }

  init {
    extend(
      CompletionType.BASIC,
      psiElement().withParents(PsiErrorElement::class.java, ZigFile::class.java),
      ZigCompletionProvider(topKeyWords)
    )

    extend(
      CompletionType.BASIC,
      psiElement(ZigLangTypes.BUILTINIDENTIFIER),
      ZigCompletionProvider(builtInFunctions)
    )
  }
}