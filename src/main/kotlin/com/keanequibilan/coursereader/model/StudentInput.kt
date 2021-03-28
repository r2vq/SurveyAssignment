package com.keanequibilan.coursereader.model

/**
 * Defines the user input.
 *
 * @property answer What the user typed.
 * @property duration How long it took the user to write this answer.
 */
data class StudentInput(
    val answer: String,
    val duration: Long
)