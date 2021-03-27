package com.keanequibilan.coursereader.view

interface View {
    /**
     * Print a message and return the user's input.
     */
    fun askForInput(message: String): String

    /**
     * Print a message.
     */
    fun printMessage(message: String)
}
