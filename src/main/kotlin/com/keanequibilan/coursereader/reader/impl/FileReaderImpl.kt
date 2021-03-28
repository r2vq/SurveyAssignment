package com.keanequibilan.coursereader.reader.impl

import com.keanequibilan.coursereader.reader.FileReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.buffer
import okio.sink
import okio.source
import java.io.File

internal class FileReaderImpl : FileReader {
    override suspend fun createFile(fileName: String): File = withContext(Dispatchers.IO) {
        File(fileName)
            .apply {
                if (exists()) {
                    delete()
                }
                createNewFile()
            }
    }

    override suspend fun readLines(file: File) = withContext(Dispatchers.IO) {
        file.source().use { fileSource ->
            fileSource.buffer().use { bufferedFileSource ->
                val lines = mutableListOf<String>()
                while (true) {
                    val line = bufferedFileSource.readUtf8Line() ?: break
                    lines.add(line)
                }
                lines.toList()
            }
        }
    }

    override suspend fun writeLines(lines: List<String>, file: File) = withContext(Dispatchers.IO) {
        file.sink().buffer().use { sink ->
            lines.forEach { line ->
                sink.writeUtf8(line)
                sink.writeUtf8("\n")
            }
        }
    }
}
