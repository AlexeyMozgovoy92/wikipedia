package org.wikipedia.screens.onboarding

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.testSettings.setName
import org.wikipedia.testSettings.withParent

class FirstOnboardingPagerItem(matcher: Matcher<View>) :
    KViewPagerItem<FirstOnboardingPagerItem>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }.setName(withParent("картинка"))

    val title = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }.setName(withParent("титул"))

    val subTitle = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }

    val addLanguageButton = KButton(matcher) {
        withId(R.id.addLanguageButton)
    }.setName(withParent("добавить или изменить язык"))


    val items by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.languageList)
            },
            itemTypeBuilder = {
                itemType(::LanguageItem)
            }
        ).setName(withParent("список"))
    }
}