package com.keanequibilan.coursereader.reader

import okio.IOException
import okio.buffer
import okio.source
import java.io.File

class FileReader {
    @Throws(IOException::class)
    fun readLines(file: File) = file.source().use { fileSource ->
        fileSource.buffer().use { bufferedFileSource ->
            while (true) {
                val line = bufferedFileSource.readUtf8Line() ?: break
                println("Line: $line")
            }
        }
    }
}