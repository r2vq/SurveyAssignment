package com.keanequibilan.coursereader.reader

import okio.IOException
import java.io.File

interface FileReader {
    @Throws(IOException::class)
    fun readLines(file: File)
}
