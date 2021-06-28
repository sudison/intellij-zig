package org.zig

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl
import com.intellij.util.ProcessingContext
import org.zig.psi.ZigFile
import org.zig.psi.ZigLangTypes


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

  private val primitiveTypesElements = ZigLangHelper.primitiveTypes.map {
    LookupElementBuilder
      .create("$it ")
      .withPresentableText(it)
      .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
  }

  private val builtInFunctions = ZigLangHelper.builtInFunctions.map {
    LookupElementBuilder
      .create("$it(")
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

    extend(CompletionType.BASIC,
           psiElement(ZigLangTypes.ID).withAncestor(6, psiElement(ZigLangTypes.FN_PROTO)),
           ZigCompletionProvider(primitiveTypesElements))
  }
}