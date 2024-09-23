package org.wikipedia.ext

import android.view.View
import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.elements.HasClass

fun BaseActions.hasClass(clazz: Class<out View>): Boolean{
    return HasClass(clazz).apply {
        view.perform(this)
    }.result.get()

}