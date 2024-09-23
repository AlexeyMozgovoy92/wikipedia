package org.wikipedia.ext

import io.github.kakaocup.kakao.tabs.KTabLayout
import org.wikipedia.elements.SelectImgTabAction

fun KTabLayout.selectImageTab(index : Int = 0) {
    view.perform(SelectImgTabAction(index))
}