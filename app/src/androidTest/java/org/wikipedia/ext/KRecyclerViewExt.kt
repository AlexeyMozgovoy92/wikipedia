package org.wikipedia.ext

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.testSettings.getName
import org.wikipedia.testSettings.setName
import org.wikipedia.testSettings.withParent

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndex(
    index: Int,
    function: T.() -> Unit
) {
    val recycler = this
    childAt<T>(index) {
        setName(recycler.getName().withParent("$index"))
        function(this)
    }
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeWithText(
    text: String,
    function: T.() -> Unit
) {
    childWith<T> {
        withDescendant {
            withText(text)
        }
    }.setName(withParent("с текстом $text")).apply(function)
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeWithClass(
    index: Int,
    clazz: Class<out View>,
    function: T.() -> Unit
) {
    var counter =0
    val recycler = this
        for (i in 0..10){
        childAt<T>(i) {
    if(hasClass(clazz) && counter++ == index){
        setName(recycler.getName().withParent("${clazz::class.java} block"))
        function(this)
        return
    }
    }

    }
throw IllegalArgumentException("block ${clazz::class.java} not found ")
}
