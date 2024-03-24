package com.android.dependencies.statistic

import org.json.JSONObject
import java.util.ServiceLoader

/**
 * @author liuzhongao
 * @since 2024/3/24 23:08
 */
internal object StatisticImpl : IStatistic {

    private const val KEY_TAG = "tag"
    private const val KEY_MESSAGE = "message"

    private val statisticPrinterList: MutableList<IStatisticPrinter> = ArrayList()

    @Volatile
    override var logLevel: LogLevel = LogLevel.Dev

    init {
        this.statisticPrinterList.clear()
        this.statisticPrinterList += ServiceLoader.load(IStatisticPrinter::class.java)
    }

    override fun addStatisticPrinter(statisticPrinter: IStatisticPrinter) {
        this.statisticPrinterList += statisticPrinter
    }

    override fun logDev(tag: String, message: String) {
        val content = JSONObject().also { jsonObject ->
            jsonObject.put(KEY_TAG, tag)
            jsonObject.put(KEY_MESSAGE, message)
        }.toString()
        this.log(LogLevel.Dev, content)
    }

    override fun logDev(tag: String, vararg param: Any?) {
        val content = JSONObject().also { jsonObject ->
            jsonObject.put(KEY_TAG, tag)
            for (index in param.indices step 2) {
                if (index in param.indices && index + 1 in param.indices) {
                    jsonObject.put(param[index].toString(), param[index + 1].toString())
                }
            }
        }.toString()
        this.log(LogLevel.Dev, content)
    }

    override fun logDev(content: String) {
        this.log(LogLevel.Dev, content)
    }

    override fun logInfo(tag: String, message: String) {
        val content = JSONObject().also { jsonObject ->
            jsonObject.put(KEY_TAG, tag)
            jsonObject.put(KEY_MESSAGE, message)
        }.toString()
        this.log(LogLevel.Info, content)
    }

    override fun logInfo(tag: String, vararg param: Any?) {
        val content = JSONObject().also { jsonObject ->
            jsonObject.put(KEY_TAG, tag)
            for (index in param.indices step 2) {
                if (index in param.indices && index + 1 in param.indices) {
                    jsonObject.put(param[index].toString(), param[index + 1].toString())
                }
            }
        }.toString()
        this.log(LogLevel.Info, content)
    }

    override fun logInfo(content: String) {
        this.log(LogLevel.Info, content)
    }

    override fun logError(tag: String, message: String) {
        val content = JSONObject().also { jsonObject ->
            jsonObject.put(KEY_TAG, tag)
            jsonObject.put(KEY_MESSAGE, message)
        }.toString()
        this.log(LogLevel.Error, content)
    }

    override fun logError(tag: String, vararg param: Any?) {
        val content = JSONObject().also { jsonObject ->
            jsonObject.put(KEY_TAG, tag)
            for (index in param.indices step 2) {
                if (index in param.indices && index + 1 in param.indices) {
                    jsonObject.put(param[index].toString(), param[index + 1].toString())
                }
            }
        }.toString()
        this.log(LogLevel.Error, content)
    }

    override fun logError(content: String) {
        this.log(LogLevel.Error, content)
    }

    override fun log(logLevel: LogLevel, content: String) {
        for (statisticPrinter in this.statisticPrinterList) {
            if (logLevel == statisticPrinter.logLevel) {
                statisticPrinter.println(content)
            }
        }
    }
}