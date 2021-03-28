package com.keanequibilan.coursereader.view.impl

import com.keanequibilan.coursereader.view.View

class ViewImpl : View {
    override fun askForInput(message: String?): String {
        print("$message: ")
        return readLine() ?: ""
    }

    override fun printMessage(message: String?) {
        println(message)
    }
}
