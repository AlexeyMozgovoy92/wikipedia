package org.wikipedia.screens.explore

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.testSettings.setName
import org.wikipedia.testSettings.withParent

class RandomArticleItem(matcher: Matcher<View>) : KRecyclerItem<RandomArticleItem>(matcher) {

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.setName(withParent("заголовок"))
    }
    val image by lazy {
        KImageView(matcher) {
            withId(R.id.articleImage)
        }.setName(withParent("картинка"))
    }
    val menu by lazy {
        KTextView(matcher){
            withId(R.id.view_list_card_header_menu)
        }.setName(withParent("меню"))
    }
    val text by lazy {
        KTextView(matcher) {
            withId(R.id.articleExtract)
        }.setName(withParent("текст"))
    }
    val articleDescription by lazy {
        KTextView(matcher) {
            withId(R.id.articleDescription)
        }.setName(withParent("описание статьи"))
    }
    val articleTitle by lazy {
        KTextView(matcher) {
            withId(R.id.articleTitle)
        }.setName(withParent("заголовок статьи"))
    }
    val buttonMoreRandomArticle by lazy {
        KButton(matcher) {
            withId(R.id.footerActionButton)
        }.setName(withParent("кнопка Больше статей"))
    }
}