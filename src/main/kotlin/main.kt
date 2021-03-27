@file:Suppress("EXPERIMENTAL_API_USAGE")

import com.keanequibilan.coursereader.Application
import com.keanequibilan.coursereader.di.APP_MODULES
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        printLogger()
        modules(APP_MODULES)
    }

    val app = Application()
    app.start()
}
