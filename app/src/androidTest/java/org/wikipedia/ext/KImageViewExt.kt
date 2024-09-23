package org.wikipedia.ext

import io.github.kakaocup.kakao.image.KImageView
import org.wikipedia.elements.HasAnyDrowableAssertion

fun KImageView.hasImage(){
    view.check(HasAnyDrowableAssertion())
}