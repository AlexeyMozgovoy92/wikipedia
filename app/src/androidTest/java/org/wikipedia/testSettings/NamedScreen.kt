package org.wikipedia.testSettings

import com.kaspersky.kaspresso.screens.KScreen
import org.wikipedia.screens.onboarding.OnboardingScreen

abstract class NamedScreen<T : KScreen<T>> : KScreen<T> (){

    abstract val screenName : String
    protected fun withParent(name : String): NameHierarchy {
        return NameHierarchy(name, NameHierarchy(OnboardingScreen.screenName))
    }


}