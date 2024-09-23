package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.Delete
import org.gradle.api.tasks.Exec

private const val ALLURE_RESULTS = "allure-results"
private const val DEVICE_REPORT_DIR = "/sdcard/Documents/$ALLURE_RESULTS"
class AllureAdbPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.afterEvaluate {
            val clearReportOnDevice = createClearReportOnDeviceTask(project)
            val clearLocalReport = createClearLocalReportTask(project)
            val copyReportFromDevice = createCopyReportFromDeviceTask(project)
            tasks.matching {
                it.name.startsWith("connected")
                        && it.name.endsWith("AndroidTest")
            }.configureEach {
                dependsOn(clearReportOnDevice, clearLocalReport)
                finalizedBy(copyReportFromDevice)
            }
        }
        createAllureServeTask(project)
    }

    private fun createCopyReportFromDeviceTask(project: Project): Task {
        return project.tasks
            .create("copyReportFromDevice", Exec::class.java).apply {
                group = "reports"
                description = "Копирует результаты текущего прогона " +
                        "с подключенного девайса в директорию сборки"
                commandLine = listOf(
                    "adb", "pull", "$DEVICE_REPORT_DIR", "${project.buildDir}"
                )
            }
    }

    private fun createClearReportOnDeviceTask(project: Project): Task {
        return project.tasks
            .create("clearReportOnDevice", Exec::class.java).apply {
                group = "reports"
                description = "Очищает результаты предыдущего прогона тестов " +
                        "на подключенном мобильном устройстве"
                commandLine = listOf(
                    "adb", "shell", "rm", "-rf", "$DEVICE_REPORT_DIR", "||", "true"
                )
            }
    }

    private fun createClearLocalReportTask(project: Project): Task {
        return project.tasks
            .create("clearLocalReport", Delete::class.java).apply {
                group = "reports"
                description = "Очищает результаты предыдущего прогона тестов " +
                        "из директории сборки"
                setDelete("${project.buildDir}/$ALLURE_RESULTS")
            }
    }

    private fun createAllureServeTask(project: Project) {
        val isWindows = System.getProperty("os.name").contains("win", true)
        val allure = if (isWindows) {
            "allure.bat"
        } else {
            "allure"
        }
        project.tasks
            .create("allureServe", Exec::class.java)
            .apply {
                group = "reports"
                description = "Выполняет генерацию Allure отчёта " +
                        "и запуск браузера с полученным отчётом"
                commandLine = listOf(
                    allure, "serve", "${project.buildDir}/$ALLURE_RESULTS"
                )
            }
    }
}