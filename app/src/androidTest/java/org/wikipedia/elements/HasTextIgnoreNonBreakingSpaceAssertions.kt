package org.wikipedia.elements

import android.view.View
import android.widget.TextView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert
import org.wikipedia.ext.getTypedView

private const val NON_BREAKING_SPACE = 160.toChar()
private const val SPACE = 32.toChar()

class HasTextIgnoreNonBreakingSpaceAssertions(val expected: String) : ViewAssertion {
    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        val typedView = getTypedView<TextView>(view, noViewFoundException)
        val actual = typedView.text.toString().replace(NON_BREAKING_SPACE, SPACE)
        val cleanExpected = expected.replace(NON_BREAKING_SPACE, SPACE)
        Assert.assertEquals(cleanExpected, actual)

    }
}