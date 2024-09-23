package org.wikipedia.screens.onboarding

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.R
import org.wikipedia.testSettings.setName
import org.wikipedia.testSettings.withParent

/**
 * OnboardingScreen - список яыков
 */
class LanguageItem(matcher: org.hamcrest.Matcher<View>) : KRecyclerItem<LanguageItem>(matcher), TextViewAssertions{

    val languageCode = KTextView(matcher){
        withId(R.id.langCodeText)
    }.setName(withParent("код языка"))

    val languageTitle = KTextView(matcher){
        withId(R.id.wiki_language_title)
    }

    val languageOrderNumber = KTextView(matcher){
        withId(R.id.wiki_language_order)
    }

    val addLanguageButton = KButton(matcher) {
        withId(R.id.wiki_language_title)
        withText("Add language")
    }
}