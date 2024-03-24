package com.android.dependencies.statistic

interface IStatisticPrinter {

    val logLevel: LogLevel

    fun println(message: String)
}