package org.wikipedia.ext

import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.elements.HasTextIgnoreNonBreakingSpaceAssertions

fun KTextView.hasTextIgnoreNonBreakingSpace(string: String){
    view.check(HasTextIgnoreNonBreakingSpaceAssertions(string))
}