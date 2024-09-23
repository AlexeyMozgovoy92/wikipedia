package org.wikipedia.screens.explore

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadListItem(matcher: Matcher<View>) : KRecyclerItem<TopReadListItem>(matcher) {

//    val number by lazy {
//        KTextView(matcher){withId(R.id.numberView)}
//    }

    val cardNumber by lazy {
        KTextView(matcher){withId(R.id.view_list_card_number)}
    }

    val title by lazy {
        KTextView(matcher){withId(R.id.view_list_card_item_title)}
    }

    val subtitle by lazy {
        KTextView(matcher){withId(R.id.view_list_card_item_subtitle)}
    }

    val image by lazy {
        KImageView(matcher){withId(R.id.view_list_card_item_image)}
    }

    val graph by lazy {
        KView(matcher){withId(R.id.view_list_card_item_graph)        }
    }

    val pageViews by lazy {
        KTextView(matcher){withId(R.id.view_list_card_item_pageviews)}
    }
}