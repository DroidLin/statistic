package com.android.dependencies.statistic

import com.android.dependencies.common.Component
import com.android.dependencies.common.ComponentInstaller

/**
 * @author liuzhongao
 * @since 2024/3/24 23:12
 */
internal class StatisticComponent : Component {

    override val name: String get() = "statistic"

    override fun collect(installer: ComponentInstaller) {
        installer.installLazily(IStatistic::class.java) { StatisticImpl }
    }
}