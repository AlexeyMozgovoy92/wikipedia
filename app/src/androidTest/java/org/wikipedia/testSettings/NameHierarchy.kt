package org.wikipedia.testSettings

class NameHierarchy(val name : String, val parent : NameHierarchy? = null) {

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, this)
    }
    override fun toString(): String {
        return parent?.let {
            "$parent : $name"
        } ?:name
    }
}