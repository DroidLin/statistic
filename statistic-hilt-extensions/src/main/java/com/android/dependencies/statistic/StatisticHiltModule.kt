package com.android.dependencies.statistic

import com.android.dependencies.common.ComponentFacade
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author liuzhongao
 * @since 2024/3/26 23:30
 */
@Module
@InstallIn(SingletonComponent::class)
internal object StatisticHiltModule {

    @Provides
    fun providesStatisticService(): IStatistic = ComponentFacade[IStatistic::class.java]
}