package org.ziglang

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PatternCondition
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.util.ProcessingContext
import org.ziglang.psi.ZigFile
import org.ziglang.psi.ZigLangTypes


class ZigCompletionProvider: CompletionProvider<CompletionParameters>() {
  override fun addCompletions(
    parameters: CompletionParameters,
    context: ProcessingContext,
    result: CompletionResultSet
  ) {

    val builder = LookupElementBuilder.create(ZigLangTypes.PUB)
    result.addElement(builder)
  }

}

private class OnStatementBeginning(vararg startWords: String) : PatternCondition<PsiElement>("on statement beginning") {
  val myStartWords = startWords
  override fun accepts(t: PsiElement, context: ProcessingContext?): Boolean {
    return true
  }
}
class ZigLangCompletionContributor : CompletionContributor() {




  init {
    extend(CompletionType.BASIC,
           psiElement().withParents(PsiErrorElement::class.java, ZigFile::class.java),
           ZigCompletionProvider())
  }
}