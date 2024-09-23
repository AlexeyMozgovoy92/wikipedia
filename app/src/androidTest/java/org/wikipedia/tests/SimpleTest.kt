package org.wikipedia.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.FlakySafetyParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import org.wikipedia.screens.explore.ExploreScreen
import org.wikipedia.screens.onboarding.OnboardingScreen

@RunWith(AndroidJUnit4::class)
class SimpleTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.simple {
        flakySafetyParams = FlakySafetyParams.custom(20_000L)
    }
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun pageIndicatorTest() {
        run("Проверка индикаторе второй страницы") {
            OnboardingScreen {
                step("Нажимает на кнопку Далее") {
                    continueButton.click()
                }
                step("Проверяет что на индикаторе вторая страница") {
                    pageIndicator.isTabSelected(1)
                }
                step("Нажимает на кнопку Пропустить") {
                    skipButton.click()
                }
            }
        }
    }

    @Test
    fun checkBackgroundHandlingTest() {
        run {
            step("run application. skip onboarding") {
                OnboardingScreen.skipButton.click()
                ExploreScreen.toolbarWordmarkWikipedia.isDisplayed()
            }
            step("app in sleep mode") {
                device.uiDevice.pressHome()
                Thread.sleep(2000)
            }
            step("back to app screen") {
                device.uiDevice.pressRecentApps()
                //device.apps.openRecent("Wikipedia")
                device.uiDevice.findObject(UiSelector().descriptionContains("Wikipedia")).click()
            }
            step("check wordMarkWikipedia is visible"){
                ExploreScreen.toolbarWordmarkWikipedia.isVisible()
            }
        }
    }


    @Test
    fun adbTest() {
        before {
            adbServer.performAdb("shell svc wifi disable")
            adbServer.performAdb("shell svc data disable")
        }.after {
            adbServer.performAdb("shell svc wifi enable")
            adbServer.performAdb("shell svc data enable")
        }.run {

            step("adbTest") {
                flakySafely(3_000L) {
                    OnboardingScreen.continueButton.isGone()
                }

            }
        }

    }
}

