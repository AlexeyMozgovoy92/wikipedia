package org.wikipedia.screens

import android.view.View
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.testSettings.setName
import org.wikipedia.testSettings.withParent

class SearchItem(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher) {

    val icon by lazy {
        KImageView(matcher) {
            withContentDescription(R.string.search_hint)
        }.setName(withParent("иконка"))
    }
    val text by lazy {
        KTextView(matcher) {
            isInstanceOf(MaterialTextView::class.java)
        }.setName(withParent("текст"))
    }

    val voiceIcon by lazy {
        KImageView(matcher) {
            withId(R.id.voice_search_button)
        }.setName(withParent("иконка звукового поиска"))
    }

}