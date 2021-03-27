package com.keanequibilan.coursereader.reader.impl

import com.keanequibilan.coursereader.reader.FileReader
import okio.IOException
import okio.buffer
import okio.source
import java.io.File

internal class FileReaderImpl : FileReader {
    @Throws(IOException::class)
    override fun readLines(file: File) = file.source().use { fileSource ->
        fileSource.buffer().use { bufferedFileSource ->
            while (true) {
                val line = bufferedFileSource.readUtf8Line() ?: break
                println("Line: $line")
            }
        }
    }
}
