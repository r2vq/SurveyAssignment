package com.keanequibilan.coursereader.repo

import com.keanequibilan.coursereader.model.StudentInput
import com.keanequibilan.coursereader.model.Subject

interface Repository {
    /**
     * Gets the question for the given [subject].
     *
     * @param subject The [Subject] to get the questions for.
     * @return The questions for that subject in a convenient [List] of [String].
     */
    suspend fun getQuestions(subject: Subject): List<String>

    /**
     * Creates the answers file.
     *
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param answers The user's answers.
     * @param subject The subject of the questions the user is answering.
     */
    suspend fun createAnswersFile(
        firstName: String,
        lastName: String,
        answers: List<StudentInput>,
        subject: Subject
    )

    /**
     * Creates the summary file.
     *
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param answers The user's answers.
     * @param subject The subject of the questions the user is answering.
     * @param quizStartTime The time in millis that the user started the quiz.
     * @param quizEndTime The time in millis that the user completed the quiz.
     */
    suspend fun createSummaryFile(
        firstName: String,
        lastName: String,
        answers: List<StudentInput>,
        subject: Subject,
        quizStartTime: Long,
        quizEndTime: Long
    )
}
