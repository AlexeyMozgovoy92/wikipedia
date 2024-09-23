package org.wikipedia.testSettings

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.common.actions.BaseActions

class ActionSteps (private val testContext: TestContext<*>) {
    operator fun invoke(action: ActionSteps.() -> Unit){
        action(this)
    }
    fun click (element: BaseActions){
        testContext.step("нажимает на элемент ${getName(element)}"){
            element.click()
        }
    }
    fun doubleClick(element: BaseActions){
        testContext.step("двойной клик ${ getName(element as BaseActions)}"){
            element.doubleClick()
        }
    }

}