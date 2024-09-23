package org.wikipedia.screens.explore

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.ext.invokeWithClass
import org.wikipedia.feed.news.NewsCardView
import org.wikipedia.feed.random.RandomCardView
import org.wikipedia.feed.searchbar.SearchCardView
import org.wikipedia.feed.view.FeedView
import org.wikipedia.screens.SearchItem
import org.wikipedia.testSettings.NamedScreen
import org.wikipedia.testSettings.getName
import org.wikipedia.testSettings.setName

object ExploreScreen : NamedScreen<ExploreScreen>() {
    override val screenName: String = "Экран главный"
    override val layoutId: Int = R.layout.fragment_feed
    override val viewClass: Class<*> = FeedView::class.java

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::InTheNewsItem)
                itemType(::CustomizeYourExploreItem)
                itemType(::SearchItem)
                itemType(::RandomArticleItem)
                itemType(::TopReadItem)
            }
        ).setName(withParent("список виджетов"))
    }
    val searchItem by lazy {
        items.childWith<SearchItem> {
            isInstanceOf(SearchCardView::class.java)
        }.setName(items.getName().withParent("блок поиска"))
    }

    fun searchItem(function: SearchItem.() -> Unit) {
        items.childWith<SearchItem> {
            isInstanceOf(SearchCardView::class.java)

        }.setName(items.getName().withParent("блок поиска")).perform(function)
    }

    fun inTheNewsItem(function: InTheNewsItem.() -> Unit) {
        items.childWith<InTheNewsItem> {
            isInstanceOf(NewsCardView::class.java)

        }.setName(items.getName().withParent("Блок В новостях")).perform(function)

    }

    val toolbarWordmarkWikipedia by lazy {
        KImageView() {
            withId(R.id.main_toolbar_wordmark)
        }
    }



        //KRecyclerView
    fun randomArticle(index: Int, function: RandomArticleItem.() -> Unit) {
            items.invokeWithClass(index, RandomCardView::class.java, function)
        }

}