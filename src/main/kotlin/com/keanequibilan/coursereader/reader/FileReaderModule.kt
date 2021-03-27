package com.keanequibilan.coursereader.reader

import com.keanequibilan.coursereader.reader.impl.FileReaderImpl
import org.koin.dsl.module

val FILE_READER_MODULE = module {
    single<FileReader> {
        FileReaderImpl()
    }
}
