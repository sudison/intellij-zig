package org.zig.reference

import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiNameIdentifierOwner

fun createLookup(s: String): LookupElement {
  return LookupElementBuilder
    .create(s)
    .withPresentableText(s)
    .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
}