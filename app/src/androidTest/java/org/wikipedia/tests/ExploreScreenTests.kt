package org.wikipedia.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.R
import org.wikipedia.ext.action
import org.wikipedia.ext.verify
import org.wikipedia.feed.random.RandomCardView
import org.wikipedia.main.MainActivity
import org.wikipedia.screens.explore.ExploreScreen

import org.wikipedia.screens.onboarding.OnboardingScreen
import org.wikipedia.screens.explore.RandomArticleItem
import org.wikipedia.screens.SearchItem


@RunWith(AndroidJUnit4::class)
class ExploreScreenTests : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun searchElementTest() {
        run("на экране explore виден блок поиска") {

            action.click(OnboardingScreen.skipButton)
            verify {
                ExploreScreen.searchItem {
                    isDisplayed(icon)
                    isDisplayed(voiceIcon)
                }
            }
        }
    }

    @Test
    fun searchTest() {
        run("на экране explore виден блок поиска") {

//            action.click(OnboardingScreen.skipButton)
            action {
                OnboardingScreen.skipButton.click()
            }
            verify {
                ExploreScreen.items.firstChild<SearchItem> {
                    isDisplayed(this)
                    isDisplayed(icon)
                    hasText(text, R.string.search_hint)
                    isDisplayed(voiceIcon)
                }
            }
        }
    }

    @Test
    fun inTheNewsTitleTest() {
        run("в блоке InTheNews отоброжается картинка на втором слайде") {

            action.click(OnboardingScreen.skipButton)
            ExploreScreen.inTheNewsItem {
                verify {
                    hasAnyText(title)
                    slide(1) {
                        image.isDisplayed()
                        text.hasAnyText()
                    }
                }
            }
        }
    }

    @Test
    fun randomArticleTest() {
        run("в блоке RandomArticle отоброжается название артикула ") {

            action.click(OnboardingScreen.skipButton)
            val randomArticleBlock = ExploreScreen.items.childWith<RandomArticleItem> {
                isInstanceOf(RandomCardView::class.java)
            }
            randomArticleBlock {
                articleTitle.hasAnyText()
            }
        }
    }


}