package org.wikipedia.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import org.wikipedia.uiscreens.OnboardingUiScreen

@RunWith(AndroidJUnit4::class)
class KautomatorTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun checkLanguageButtonTest() {
        run {
            step("проверяем текст кнопки") {
                OnboardingUiScreen.languageButton.hasText("Add or edit language")
            }
        }
    }

    @Test
    fun checkTabSelectorTest() {
        run {
            OnboardingUiScreen {
                step("проверяем что кнопка Skip отображается") {
                    buttonSkip.isDisplayed()
                }
                step("проверяем что кнопка continue отображается") {
                    buttonContinue.isDisplayed()
                }
                val pagerIndicator = device.uiDevice.findObject(
                    By.res("org.wikipedia.dev:id/view_onboarding_page_indicator")
                )
                val tab0 = pagerIndicator.children[0].children[0]
                val tab1 = pagerIndicator.children[0].children[1]

                step("проверяет что tab1 выбран") {
                    Assert.assertTrue(tab1.isSelected)
                }
            }
        }
    }
}