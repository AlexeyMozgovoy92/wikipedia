package org.wikipedia.screens.explore

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {

    val title by lazy {
        KTextView(matcher) {
            R.id.view_card_header_title
        }
    }

    val menu by lazy {
        KImageView(matcher) {
            R.id.view_list_card_header_menu
        }
    }

    val list by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType(::TopReadListItem)
            }
        )
    }
}