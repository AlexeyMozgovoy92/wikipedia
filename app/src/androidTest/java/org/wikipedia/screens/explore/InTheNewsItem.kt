package org.wikipedia.screens.explore

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.testSettings.getName
import org.wikipedia.testSettings.setName
import org.wikipedia.testSettings.withParent

class InTheNewsItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsItem>(matcher) {

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.setName(withParent("заголовок"))
    }

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.horizontal_scroll_list_item_image)
        }.setName(withParent("картинка"))
    }

    val menu by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.setName(withParent("меню"))
    }

    val slides by lazy {
            KRecyclerView(
                parent = matcher,
                builder = {
                    withId(R.id.news_cardview_recycler_view)
                },
                itemTypeBuilder = {
                    itemType(::InTheNewsSliderItem)
                }
            ).setName(withParent("список слайдов"))
        }

    fun slide(index:Int, function : InTheNewsSliderItem.() -> Unit){
        slides.childAt<InTheNewsSliderItem>(index){
            setName(this@InTheNewsItem.slides.getName().withParent("$index"))
            function()
        }
    }
}