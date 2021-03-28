package com.keanequibilan.coursereader.presenter

import com.keanequibilan.coursereader.presenter.impl.PresenterImpl
import com.keanequibilan.coursereader.repo.Repository
import org.koin.dsl.module

val PRESENTER_MODULE = module {
    factory<Presenter> {
        val repository: Repository = get()
        val timeProvider = {
            System.currentTimeMillis()
        }

        PresenterImpl(
            repo = repository,
            getCurrentTime = timeProvider
        )
    }
}
