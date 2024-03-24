package com.android.dependencies.statistic

interface IStatistic {

    var logLevel: LogLevel

    /**
     * 添加额外的Printer
     */
    fun addStatisticPrinter(statisticPrinter: IStatisticPrinter)

    /**
     * 打印debug日志
     *
     * @param tag 日志标识，用于定位某条日志用
     * @param message 日志消息体
     */
    fun logDev(tag: String, message: String)

    /**
     * 打印debug日志
     *
     * @param tag 日志标识，用于定位某条日志用
     * @param param 可变参数键值对，如果参数长度不是偶数，会舍弃最后一个
     */
    fun logDev(tag: String, vararg param: Any?)

    /**
     * 打印debug日志
     *
     * @param content 日志原始内容，不会做任何格式化处理
     */
    fun logDev(content: String)

    /**
     * 打印info日志，该日志会作为记录写入文件，无特殊标识
     *
     * @param tag 日志标识，用于定位某条日志用
     * @param message 日志消息体
     */
    fun logInfo(tag: String, message: String)

    /**
     * 打印info日志，该日志会作为记录写入文件，无特殊标识
     *
     * @param tag 日志标识，用于定位某条日志用
     * @param param 可变参数键值对，如果参数长度不是偶数，会舍弃最后一个
     */
    fun logInfo(tag: String, vararg param: Any?)

    /**
     * 打印info日志，该日志会作为记录写入文件，无特殊标识
     *
     * @param content 日志原始内容，不会做任何格式化处理
     */
    fun logInfo(content: String)

    /**
     * 打印error日志，该日志会被记录写入文件，有error标识
     *
     * @param tag 日志标识，用于定位某条日志用
     * @param message 日志消息体
     */
    fun logError(tag: String, message: String)

    /**
     * 打印error日志，该日志会被记录写入文件，有error标识
     *
     * @param tag 日志标识，用于定位某条日志用
     * @param param 可变参数键值对，如果参数长度不是偶数，会舍弃最后一个
     */
    fun logError(tag: String, vararg param: Any?)

    /**
     * 打印error日志，该日志会被记录写入文件，有error标识
     *
     * @param content 日志原始内容，不会做任何格式化处理
     */
    fun logError(content: String)

    fun log(logLevel: LogLevel, content: String)
}