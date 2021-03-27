package com.keanequibilan.coursereader.di

import com.keanequibilan.coursereader.reader.FileReader
import org.koin.dsl.module

val appModule = module {
    single {
        FileReader()
    }
}