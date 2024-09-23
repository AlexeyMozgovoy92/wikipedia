package org.wikipedia.screens.explore

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class PictureOfTheDayItem(matcher: Matcher<View>) : KRecyclerItem<PictureOfTheDayItem>(matcher) {

    val title = KTextView(matcher){
        withId(R.id.view_card_header_title)
    }

    val image = KImageView(matcher) {
        withId(R.id.view_featured_image_card_image)
    }

    val menu = KTextView(matcher){
        withId(R.id.view_list_card_header_menu)
    }
    val text = KTextView(matcher){
        withId(R.id.view_featured_image_card_image_description)
    }

    val buttonDownload = KButton(matcher){
        withId(R.id.view_featured_image_card_download_button)
    }

    val buttonShare = KButton(matcher){
        withId(R.id.view_featured_image_card_share_button)
    }
}