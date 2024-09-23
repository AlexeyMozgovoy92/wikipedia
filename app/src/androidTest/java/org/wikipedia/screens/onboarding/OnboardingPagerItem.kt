package org.wikipedia.screens.onboarding

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OnboardingPagerItem(matcher: Matcher<View>) : KViewPagerItem<OnboardingPagerItem>(matcher) {

    val image by lazy {
        KImageView(matcher) { withId(R.id.imageViewCentered) }
    }

    val title by lazy {
        KTextView(matcher) { withId(R.id.primaryTextView) }
    }

    val subtitle by lazy {
        KTextView(matcher) { withId(R.id.secondaryTextView) }
    }
}