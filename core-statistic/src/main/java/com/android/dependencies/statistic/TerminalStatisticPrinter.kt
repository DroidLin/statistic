package com.android.dependencies.statistic

import java.util.logging.Logger

/**
 * @author liuzhongao
 * @since 2024/3/24 23:14
 */
internal class TerminalStatisticPrinter : IStatisticPrinter {

    private val terminalLogger by lazy { Logger.getLogger("Terminal") }

    override val logLevel: LogLevel get() = LogLevel.Dev

    override fun println(message: String) {
        this.terminalLogger.info(message)
    }
}