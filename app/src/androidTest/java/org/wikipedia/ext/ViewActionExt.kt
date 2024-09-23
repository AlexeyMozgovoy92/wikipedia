package org.wikipedia.ext

import android.view.View
import androidx.test.espresso.ViewAction
import java.lang.IllegalArgumentException

inline fun <reified T : View> ViewAction.getTypedView(view: View?): T {
    return view?.let {
        it as? T ?: throw IllegalArgumentException("View in not ${T::class.java.name}")
    } ?: throw IllegalArgumentException("View in null")
}