package org.wikipedia.testSettings

import androidx.annotation.StringRes
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.ext.hasTextIgnoreNonBreakingSpace

class VerifySteps(private val testContext: TestContext<*>) {

    operator fun invoke(action: VerifySteps.() -> Unit) {
        action(this)
    }

    fun isDisplayed(element: BaseAssertions) {
        testContext.step("Проверяет отображение элемента '${getName(element as BaseActions)}'") {
            element.isDisplayed()
        }
    }


    fun isNotDisplayed(element: BaseAssertions) {
        testContext.step("Проверяет что элемент не отображен  '${getName(element as BaseActions)}'") {
            element.isNotDisplayed()
        }
    }

    fun isVisible(element: BaseAssertions) {
        testContext.step("Проверяет что элемент виден  '${getName(element as BaseActions)}'") {
            element.isVisible()
        }
    }

    fun hasText(element: TextViewAssertions, @StringRes resId: Int) {
        testContext.step("проверяет наличие текста в '${getName(element as BaseActions)}'") {
            element.hasText(resId)
        }
    }

    fun hasText(element: KTextView, text: String) {
        testContext.step("проверяет соответствие текста '${text}' с '${getName(element as BaseActions)}'") {
            element.hasTextIgnoreNonBreakingSpace(text)
        }
    }

    fun hasAnyText(element: TextViewAssertions) {
        testContext.step("проверяет наличие любого текста '${getName(element as BaseActions)}'") {
            element.hasAnyText()
        }
    }

}