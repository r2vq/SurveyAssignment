package com.keanequibilan.coursereader.model

sealed class Subject {
    /**
     * Used to calculate the file names. These should be a 1 to 1 match with the companion objects.
     */
    protected abstract val subjectName: String

    /**
     * Returns the file name of the quiz questions. Make sure this exists!
     */
    fun getQuizFileName(): String = "$subjectName/quiz.txt"

    /**
     * Returns the file name of where the quiz answers will be stored.
     */
    fun getAnswerFileName(
        firstName: String,
        lastName: String
    ): String = "${lastName}_${firstName}_answers_$subjectName.txt".toLowerCase().replace(" ", "_")

    /**
     * Returns the file name of where the quiz summary will be stored.
     */
    fun getSummaryFileName(
        firstName: String,
        lastName: String
    ): String = "${lastName}_${firstName}_summary_$subjectName.txt".toLowerCase().replace(" ", "_")

    companion object {
        const val MATH = "math"
        const val SCIENCE = "science"
        const val HISTORY = "history"
    }
}

class HistorySubject : Subject() {
    override val subjectName: String = HISTORY
}

class MathSubject : Subject() {
    override val subjectName: String = MATH
}

class ScienceSubject : Subject() {
    override val subjectName: String = SCIENCE
}
