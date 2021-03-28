package com.keanequibilan.coursereader.presenter.impl

import com.keanequibilan.coursereader.model.*
import com.keanequibilan.coursereader.presenter.Presenter
import com.keanequibilan.coursereader.repo.Repository
import com.keanequibilan.coursereader.view.View

class PresenterImpl(
    private val repo: Repository,
    private val getCurrentTime: () -> Long
) : Presenter {
    private var _view: View? = null

    override suspend fun startSurvey(subjectName: String) {
        val quizStartTime = getCurrentTime()

        val subject = when (subjectName) {
            Subject.MATH -> MathSubject()
            Subject.HISTORY -> HistorySubject()
            Subject.SCIENCE -> ScienceSubject()
            else -> throw IllegalArgumentException("Invalid subject passed in: \"$subjectName\". Expected one of: [${Subject.MATH}|${Subject.HISTORY}|${Subject.SCIENCE}]")
        }

        val firstName = askQuestion("First Name")
        val lastName = askQuestion("Last Name")

        val questions = repo.getQuestions(subject)
        val answers = questions.map { question ->
            val questionStartTime = getCurrentTime()
            val answer = askQuestion(question)
            val questionEndTime = getCurrentTime()
            StudentInput(
                answer = answer,
                duration = questionEndTime - questionStartTime
            )
        }
        val quizEndTime = getCurrentTime()

        repo.createAnswersFile(firstName, lastName, answers, subject)
        repo.createSummaryFile(firstName, lastName, answers, subject, quizStartTime, quizEndTime)
    }

    override fun setView(view: View?) {
        _view = view
    }

    private fun askQuestion(question: String): String = _view?.askForInput(question) ?: ""
}
