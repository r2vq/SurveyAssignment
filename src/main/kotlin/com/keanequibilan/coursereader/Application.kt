package com.keanequibilan.coursereader

import com.keanequibilan.coursereader.presenter.Presenter
import com.keanequibilan.coursereader.view.View
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@KoinApiExtension
class Application(
    private val args: Array<String>
) : KoinComponent {
    private val presenter: Presenter by inject()
    private val view: View by inject()

    suspend fun start() {
        presenter.setView(view)

        val subjectName = args.firstOrNull() ?: throw IllegalArgumentException("At least one argument expected.")
        presenter.startSurvey(subjectName)
    }
}
