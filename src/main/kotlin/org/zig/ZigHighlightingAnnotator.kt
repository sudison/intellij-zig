package org.zig

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import org.zig.psi.ZigLangTypes


class ZigHighlightingAnnotator : Annotator {
  override fun annotate(element: PsiElement, holder: AnnotationHolder) {
    when(element.elementType) {
      ZigLangTypes.ID -> {
        val parent = element.parent ?: return
        when (parent.elementType) {
          ZigLangTypes.FN_PROTO -> {
            holder
              .newSilentAnnotation(HighlightSeverity.INFORMATION)
              .textAttributes(
                DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
              )
              .create()
          }
        }
      }
      else -> return
    }
  }
}