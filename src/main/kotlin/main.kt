@file:Suppress("EXPERIMENTAL_API_USAGE")

import com.keanequibilan.coursereader.Application
import com.keanequibilan.coursereader.di.appModule
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        printLogger()
        modules(appModule)
    }

    val app = Application()
    app.start()
}
