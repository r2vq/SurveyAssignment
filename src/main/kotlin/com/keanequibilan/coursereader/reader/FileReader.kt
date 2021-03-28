package com.keanequibilan.coursereader.reader

import java.io.File

interface FileReader {

    /**
     * Create the file with the given [fileName]. If the file already exists, this method will delete the file before
     * creating a new one.
     *
     * @param fileName the name of the file to create.
     */
    suspend fun createFile(fileName: String): File

    /**
     * Read the lines in the given [file] and return them in a [List] of [String].
     *
     * @param file The [File] to read
     * @return The lines in the given [file].
     */
    suspend fun readLines(file: File): List<String>

    /**
     * Write the given [lines] to the given [file].
     *
     * @param lines The [List] of [String] that we will write to the file. Each list item is a new line.
     * @param file The [File] to write to.
     */
    suspend fun writeLines(lines: List<String>, file: File)
}
