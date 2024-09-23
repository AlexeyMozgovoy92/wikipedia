package org.wikipedia.testSettings

import androidx.annotation.StringRes
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions

class Steps( private val testContext: TestContext<*>) {

    operator fun invoke(action: Steps.() -> Unit){
        action(this)
    }

    fun click (element: BaseActions){
        testContext.step("нажимает на элемент ${getName(element)}"){
            element.click()
        }
    }

    fun isDisplayed(element: BaseAssertions, name: String){
        testContext.step("проверяет отображение элемента '$name'"){
            element.isDisplayed()
        }
    }

    fun hasText(element: TextViewAssertions, @StringRes resId: Int){
        testContext.step("проверяет наличие текста в '$ '"){
            element.hasText(resId)
        }
    }



}