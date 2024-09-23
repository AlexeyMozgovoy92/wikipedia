package org.wikipedia.screens

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.testSettings.setName
import org.wikipedia.testSettings.withParent

class SearchResultItem(matcher: Matcher<View>) : KRecyclerItem<SearchResultItem>(matcher) {

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.page_list_item_title)
        }.setName(withParent("заголовок"))
    }

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.page_list_item_image)
        }.setName(withParent("картинка"))
    }

    val description by lazy {
        KTextView(matcher) {
            withId(R.id.page_list_item_description)
        }.setName(withParent("описание"))
    }

}