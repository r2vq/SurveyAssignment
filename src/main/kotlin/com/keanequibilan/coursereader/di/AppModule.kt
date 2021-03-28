package com.keanequibilan.coursereader.di

import com.keanequibilan.coursereader.reader.FILE_READER_MODULE
import com.keanequibilan.coursereader.repo.REPOSITORY_MODULE
import com.keanequibilan.coursereader.view.VIEW_MODULE
import com.keanequibilan.coursereader.presenter.PRESENTER_MODULE
import org.koin.core.module.Module

val APP_MODULES: List<Module> = listOf(
    FILE_READER_MODULE,
    REPOSITORY_MODULE,
    PRESENTER_MODULE,
    VIEW_MODULE
)
