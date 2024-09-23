package org.wikipedia.screens

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.testSettings.setName
import org.wikipedia.testSettings.withParent

class HistoryItem(matcher: Matcher<View>) : KRecyclerItem<HistoryItem>(matcher) {

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.history_title)
        }.setName(withParent("заголовок"))
    }
}