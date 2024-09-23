package org.wikipedia.ext

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.wikipedia.testSettings.ActionSteps
import org.wikipedia.testSettings.VerifySteps
import org.wikipedia.testSettings.Steps

val TestContext<*>.steps: Steps
    get() = Steps(this)

val TestContext<*>.verify: VerifySteps
    get() = VerifySteps(this)

val TestContext<*>.action: ActionSteps
    get() = ActionSteps(this)