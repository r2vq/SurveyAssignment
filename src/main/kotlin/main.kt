@file:Suppress("EXPERIMENTAL_API_USAGE")

import com.keanequibilan.coursereader.Application
import com.keanequibilan.coursereader.di.APP_MODULES
import kotlinx.coroutines.runBlocking
import org.koin.core.context.startKoin

fun main(args: Array<String>) {
    startKoin {
        printLogger()
        modules(APP_MODULES)
    }

    val app = Application(args)

    try {
        runBlocking {
            app.start()
        }
    } catch (e: Exception) {
        println("Application failed to run. Reason:")
        println(e.message)
    }
}
