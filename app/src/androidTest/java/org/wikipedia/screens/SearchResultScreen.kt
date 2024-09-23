package org.wikipedia.screens

import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.ext.invokeAtIndex
import org.wikipedia.ext.invokeWithText
import org.wikipedia.testSettings.NamedScreen
import org.wikipedia.testSettings.setName
import androidx.appcompat.R as appcompatR

object SearchResultScreen : NamedScreen<SearchResultScreen>() {
    override val screenName: String = "Экран результатов поиска"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchField by lazy {
        KEditText {
            withId(appcompatR.id.search_src_text)
        }.setName(withParent("поле поиска"))
    }

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.search_results_list)
            },
            itemTypeBuilder = {
                itemType(::SearchResultItem)
            }
        ).setName(withParent("список результатов поиска"))
    }

    fun item(index: Int, function: SearchResultItem.() -> Unit) {
        items.invokeAtIndex(index, function)

    }

    fun item(text: String, function: SearchResultItem.() -> Unit){
        items.invokeWithText(text, function)

    }
}
