package org.wikipedia.main

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

val voiceSearchButton = KImageView{
    withText(R.id.voice_search_button)
}
val toolbar = KToolbar{
    withId(R.id.main_toolbar)
}
val buttomLoupe = KImageView{
    withParent { withId(R.id.search_container) }
    onPosition(0)
    withContentDescription("Search Wikipedia")
}
val editSearchField = KTextView{
    withText("Search Wikipedia")
}