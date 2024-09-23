package org.wikipedia.elements

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import com.google.android.material.tabs.TabLayout
import org.hamcrest.Matcher
import org.wikipedia.ext.getTypedView

class SelectImgTabAction(private val index: Int) : ViewAction {
    override fun getDescription() = "Выбирает таб с иконкой "

    override fun getConstraints(): Matcher<View> {
        TODO("Not yet implemented")
    }

    override fun perform(uiController: UiController?, view: View?) {
        val typedView = getTypedView<TabLayout>(view)
        var counter = 0
        for (i in 0 until typedView.tabCount) {
            val tab = typedView.getTabAt(i)
            if (tab?.text.isNullOrBlank()
            ) {
                if (counter++ == index) {
                    tab?.select()
                    return
                }
            }
        }
        throw IllegalArgumentException("вкладка с картинкой c идексом $index не обнаружена")
    }
}