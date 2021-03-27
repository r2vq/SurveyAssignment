package com.keanequibilan.coursereader.repo

import com.keanequibilan.coursereader.repo.impl.RepositoryImpl
import org.koin.dsl.module

val REPOSITORY_MODULE = module {
    single<Repository> {
        RepositoryImpl()
    }
}
