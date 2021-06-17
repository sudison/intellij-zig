package org.ziglang

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PatternCondition
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiElement
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

private class OnStatementBeginning(vararg startWords: String) : PatternCondition<PsiElement>("on statement beginning") {
  val myStartWords = startWords
  override fun accepts(t: PsiElement, context: ProcessingContext?): Boolean {
    return true
  }
}

class ZigLangCompletionContributor : CompletionContributor() {

  private val topKeyWords = listOf(
    ZigLangTypes.CONST,
    ZigLangTypes.VAR,
    ZigLangTypes.FN,
    ZigLangTypes.PUB
  ).map {
    LookupElementBuilder
      .create("$it ")
      .withPresentableText(it.toString())
      .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
  }

  init {
    extend(
      CompletionType.BASIC,
      psiElement().withParents(PsiErrorElement::class.java, ZigFile::class.java),
      ZigCompletionProvider(topKeyWords)
    )
  }
}