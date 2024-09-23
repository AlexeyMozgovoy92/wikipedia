package org.wikipedia.ext

import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion

inline fun <reified T : View> ViewAssertion.getTypedView(
    view: View?,
    noViewFoundException: NoMatchingViewException?
): T {
    return view as? T ?: throw (noViewFoundException
        ?: IllegalArgumentException("View is no ${T::class.java.name}"))
}