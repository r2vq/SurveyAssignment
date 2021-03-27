package com.keanequibilan.coursereader.reader.impl

import com.keanequibilan.coursereader.reader.FileReader
import okio.IOException
import okio.buffer
import okio.sink
import okio.source
import java.io.File

internal class FileReaderImpl : FileReader {
    @Throws(IOException::class)
    override fun readLines(file: File) = file.source().use { fileSource ->
        fileSource.buffer().use { bufferedFileSource ->
            val lines = mutableListOf<String>()
            while (true) {
                val line = bufferedFileSource.readUtf8Line() ?: break
                lines.add(line)
            }
            lines.toList()
        }
    }

    @Throws(IOException::class)
    override fun writeLines(lines: List<String>, file: File) {
        file.sink().buffer().use { sink ->
            lines.forEach { line ->
                sink.writeUtf8(line)
                sink.writeUtf8("\n")
            }
        }
    }
}
