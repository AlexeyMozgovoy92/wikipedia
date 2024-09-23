package org.wikipedia.testSettings

import io.github.kakaocup.kakao.common.actions.BaseActions

private val names = mutableMapOf<BaseActions, NameHierarchy>()
fun getName(element: BaseActions): String {
    val name = names.getOrDefault(element, defaultValue = NameHierarchy("NO_LABEL"))
    return name.toString()
}

fun <T : BaseActions> T.getName(): NameHierarchy {
    return names.getOrDefault(this, defaultValue = NameHierarchy("NO_LABEL"))
}

fun <T : BaseActions> T.withParent(name: String): NameHierarchy {
    return getName().withParent(name)
}

fun setName(element: BaseActions, nameHierarchy: NameHierarchy) {
    names[element] = nameHierarchy
}

fun <T : BaseActions> T.setName(nameHierarchy: NameHierarchy): T {
    names[this] = nameHierarchy
    return this
}

