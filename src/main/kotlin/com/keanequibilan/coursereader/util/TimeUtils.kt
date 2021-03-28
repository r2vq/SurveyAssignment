package com.keanequibilan.coursereader.util

private const val SECONDS_IN_MINUTES = 60
private const val SECONDS_IN_HOURS = 3600
private const val MILLIS_IN_SECONDS = 1000

/**
 * Call on a time duration in millis and this will format the time in "00h : 00m : 00s" format.
 *
 * @return The formatted duration time.
 */
fun Long.formatTime(): String {
    var durationRemaining = this / MILLIS_IN_SECONDS
    val hours = durationRemaining / SECONDS_IN_HOURS
    durationRemaining %= SECONDS_IN_HOURS
    val minutes = durationRemaining / SECONDS_IN_MINUTES
    durationRemaining %= SECONDS_IN_MINUTES
    val seconds = durationRemaining
    return String.format("%dh : %02dm : %02ds", hours.toInt(), minutes.toInt(), seconds.toInt())
}