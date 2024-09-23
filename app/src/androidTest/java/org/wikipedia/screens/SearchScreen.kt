package org.wikipedia.screens

import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.ext.invokeAtIndex
import org.wikipedia.testSettings.NamedScreen
import org.wikipedia.testSettings.setName
import androidx.appcompat.R as appCompatR

object SearchScreen: NamedScreen<SearchScreen>() {
    override val screenName: String = "Экран поиска"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchInput by lazy {
        KEditText {
            withId(appCompatR.id.search_src_text)
        }.setName(withParent("поле поиска"))
    }
    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.languageList)
            },
            itemTypeBuilder = {
                itemType(::HistoryItem)
            }
        )
    }
    fun item(index: Int, function: HistoryItem.() -> Unit){
        items.invokeAtIndex(index, function)

    }
}