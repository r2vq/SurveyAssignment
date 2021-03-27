package com.keanequibilan.coursereader.vm

import com.keanequibilan.coursereader.vm.impl.ViewModelImpl
import org.koin.dsl.module

val VIEW_MODEL_MODULE = module {
    factory<ViewModel> {
        ViewModelImpl()
    }
}
