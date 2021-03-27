package com.keanequibilan.coursereader

import com.keanequibilan.coursereader.reader.FileReader
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.File

@KoinApiExtension
class Application : KoinComponent {
    private val reader: FileReader by inject()

    fun start() {
        println("Open which file?")
        val fileName = readLine()?.takeIf { it.isNotEmpty() && it.isNotBlank() }

        fileName?.let {
            println("Opening $fileName!")

            val file = File(fileName)
            reader.readLines(file)
        } ?: run {
            println("No file name provided.")
        }
    }
}
