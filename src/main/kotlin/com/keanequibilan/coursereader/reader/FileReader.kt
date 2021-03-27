package com.keanequibilan.coursereader.reader

import okio.IOException
import java.io.File

interface FileReader {
    @Throws(IOException::class)
    fun readLines(file: File): List<String>

    @Throws(IOException::class)
    fun writeLines(lines: List<String>, file: File)
}
