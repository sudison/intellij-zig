package org.zig

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.ObjectPattern
import com.intellij.patterns.PatternCondition
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.util.ProcessingContext
import org.zig.psi.ZigFile
import org.zig.psi.ZigLangTypes
import org.zig.types.leftSiblings

fun <T, Self : ObjectPattern<T, Self>> ObjectPattern<T, Self>.with(name: String, cond: (T) -> Boolean): Self =
  with(object : PatternCondition<T>(name) {
    override fun accepts(t: T, context: ProcessingContext?): Boolean = cond(t)
  })

fun <T : PsiElement, Self : PsiElementPattern<T, Self>> PsiElementPattern<T, Self>.withPrevSiblingSkipping(
  skip: ElementPattern<out T>,
  pattern: ElementPattern<out T>
): Self = with("withPrevSiblingSkipping") { e ->
  val sibling = e.leftSiblings.dropWhile { skip.accepts(it) }
    .firstOrNull() ?: return@with false
  pattern.accepts(sibling)
}

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

  private val containerDecl =
    listOf(
      ZigLangTypes.STRUCT,
      ZigLangTypes.ENUM,
      ZigLangTypes.OPAQUE,
      ZigLangTypes.UNION,
      ZigLangTypes.EXTERN,
      ZigLangTypes.PACKED
    ).map {
      LookupElementBuilder
        .create(it.toString().toLowerCase())
        .withPresentableText(it.toString().toLowerCase())
        .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
    }

  private val containerAutoDecl =
    listOf(
      ZigLangTypes.STRUCT,
      ZigLangTypes.ENUM,
      ZigLangTypes.OPAQUE,
      ZigLangTypes.UNION,
    ).map {
      LookupElementBuilder
        .create(it.toString().toLowerCase())
        .withPresentableText(it.toString().toLowerCase())
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

    // "const Point = s"
    extend(
      CompletionType.BASIC,
      psiElement(ZigLangTypes.ID).withAncestor(2, psiElement(ZigLangTypes.PRIMARY_TYPE_EXPR)),
      ZigCompletionProvider(containerDecl)
    )

    // "const Point = packed s"
    extend(
      CompletionType.BASIC,
      psiElement(ZigLangTypes.ID).withParent(
        psiElement(ZigLangTypes.CONTAINER_FIELD).withPrevSiblingSkipping(
          psiElement().whitespace(),
          psiElement(
            PsiErrorElement::class.java
          )
        )
      ),
      ZigCompletionProvider(containerAutoDecl)
    )

    extend(
      CompletionType.BASIC,
      psiElement(ZigLangTypes.BUILTINIDENTIFIER),
      ZigCompletionProvider(builtInFunctions)
    )

    extend(
      CompletionType.BASIC,
      psiElement(ZigLangTypes.ID).withAncestor(6, psiElement(ZigLangTypes.FN_PROTO)),
      ZigCompletionProvider(ZigLangHelper.primitiveTypesLookup)
    )
  }
}