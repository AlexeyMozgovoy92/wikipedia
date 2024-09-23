plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        register("allure-adb-plugin") {
            id = "allure-adb-plugin"
            description = "Clear and copy allure results from device"
            implementationClass = "plugins.AllureAdbPlugin"
            group = "Reports"
        }
    }
}
