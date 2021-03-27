package com.keanequibilan.coursereader.view

import com.keanequibilan.coursereader.view.impl.ViewImpl
import org.koin.dsl.module

val VIEW_MODULE = module {
    factory<View> {
        ViewImpl()
    }
}
