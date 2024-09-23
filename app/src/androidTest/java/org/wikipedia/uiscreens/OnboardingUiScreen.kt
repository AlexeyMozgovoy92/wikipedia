package org.wikipedia.uiscreens

import androidx.test.uiautomator.By
import com.kaspersky.components.kautomator.component.common.builders.UiViewSelector
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen : UiScreen<OnboardingUiScreen>(){
    override val packageName: String = "OnboardingUiScreen"

    val languageButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "addLanguageButton")
    }

    val buttonSkip = UiButton{
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val image = UiView(
        UiViewSelector(
            0,
            By.res("imageViewCentered")
                .pkg(packageName)
        )
    )

    val buttonContinue = UiButton{
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }
}