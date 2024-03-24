package com.android.dependencies.statistic

interface IStatistic {

    var logLevel: LogLevel

    fun addStatisticPrinter(statisticPrinter: IStatisticPrinter)

    fun logDev(tag: String, message: String)

    fun logDev(tag: String, vararg param: Any?)

    fun logDev(content: String)

    fun logInfo(tag: String, message: String)

    fun logInfo(tag: String, vararg param: Any?)

    fun logInfo(content: String)

    fun logError(tag: String, message: String)

    fun logError(tag: String, vararg param: Any?)

    fun logError(content: String)

    fun log(logLevel: LogLevel, content: String)
}