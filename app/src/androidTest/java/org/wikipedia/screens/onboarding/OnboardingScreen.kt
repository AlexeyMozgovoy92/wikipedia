package org.wikipedia.screens.onboarding

import android.widget.FrameLayout
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.testSettings.NamedScreen
import org.wikipedia.testSettings.setName

object OnboardingScreen: NamedScreen<OnboardingScreen>() {
    override val screenName: String = "Экран Онбординга"
    override val layoutId: Int = R.layout.fragment_onboarding_pager
    override val viewClass: Class<*> = FrameLayout::class.java

    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }.setName(withParent("продолжить"))


    val pageIndicator = KTabLayout {
        withId(R.id.view_onboarding_page_indicator)
    }

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }.setName(withParent("пропустить"))

    val getStartedButton = KButton {
        withId(R.id.fragment_onboarding_done_button)
    }.setName(withParent("приступить"))

    val items by lazy {
        KViewPager2(
            builder = {
                withId(R.id.fragment_pager)
            },
            itemTypeBuilder = {
                itemType(::FirstOnboardingPagerItem)
                itemType(::OnboardingPagerItem)
            }
        ).setName(withParent("список"))
    }

    fun onboardingPagerItemWithIndex(index: Int, function: OnboardingPagerItem.() -> Unit) {
        items.childAt<OnboardingPagerItem>(index) { function }
    }

}

//        val buttonSkip = KButton{
//            withId(R.id.fragment_onboarding_skip_button)
//        }.also { names[it] = "кнопка пропустить" }



