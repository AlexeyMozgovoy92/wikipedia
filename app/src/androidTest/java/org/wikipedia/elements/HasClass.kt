package org.wikipedia.elements

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher
import org.wikipedia.ext.getTypedView
import java.util.concurrent.atomic.AtomicBoolean

class HasClass(private val clazz: Class<out View>) : ViewAction{
    val result = AtomicBoolean(false)
    override fun getDescription(): String {
        return "check that view has class"
    }

    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun perform(uiController: UiController?, view: View?) {
        val typed = getTypedView<View>(view)
        result.set(clazz.isAssignableFrom(typed::class.java))
    }

}