package com.keanequibilan.coursereader.presenter

import com.keanequibilan.coursereader.view.View

interface Presenter {

    /**
     * Starts the survey for the given subject.
     *
     * @param subjectName The name of the subject to start the survey for.
     */
    suspend fun startSurvey(subjectName: String)

    /**
     * Set the view so the presenter can present. Set to null for GC purposes.
     *
     * @param view The [View] to set.
     */
    fun setView(view: View?)
}
