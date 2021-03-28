package com.keanequibilan.coursereader.repo.impl

import com.keanequibilan.coursereader.model.StudentInput
import com.keanequibilan.coursereader.model.Subject
import com.keanequibilan.coursereader.reader.FileReader
import com.keanequibilan.coursereader.repo.Repository
import com.keanequibilan.coursereader.util.formatTime
import java.io.File

class RepositoryImpl(
    private val reader: FileReader
) : Repository {
    override suspend fun getQuestions(subject: Subject): List<String> = reader
        .readLines(File(subject.getQuizFileName()))

    override suspend fun createAnswersFile(
        firstName: String,
        lastName: String,
        answers: List<StudentInput>,
        subject: Subject
    ) {
        val fileName = subject.getAnswerFileName(firstName, lastName)
        val file = reader.createFile(fileName)
        val lines = answers.map { it.answer }
        reader.writeLines(lines, file)
    }

    override suspend fun createSummaryFile(
        firstName: String,
        lastName: String,
        answers: List<StudentInput>,
        subject: Subject,
        quizStartTime: Long,
        quizEndTime: Long
    ) {
        val lines = mutableListOf<String>()

        val fileName = subject.getSummaryFileName(firstName, lastName)
        val file = reader.createFile(fileName)

        val answerWords = answers.flatMap { it.answer.split(" ") }
        val firstNameWords = firstName.split(" ")
        val lastNameWords = lastName.split(" ")
        val words = answerWords.plus(firstNameWords).plus(lastNameWords).count()
        lines.add("Total Words Entered: $words (including name)")

        answers
            .mapIndexed { index, studentInput -> index + 1 to studentInput.duration }
            .map { (questionNumber, time) -> "Question $questionNumber Duration: ${time.formatTime()}" }
            .let { lines.addAll(it) }

        (quizEndTime - quizStartTime)
            .let { time ->
                "Total duration: ${time.formatTime()} (including name)"
            }
            .let { lines.add(it) }

        reader.writeLines(lines, file)
    }
}
