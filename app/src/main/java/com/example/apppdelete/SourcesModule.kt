package com.example.apppdelete

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object SourcesModule {

    @Provides
    fun provideSourcesOnlineDataSource(
        wepServices: WepServices
    ): SourcesOnlineDataSource {

        return SourcesOnlineDataSourceImpl(wepServices)
    }

    @Provides
    fun provideSourcesRepo(sourcesOnlineDataSource: SourcesOnlineDataSource): SourcesRepo {

        return SourcesRepoImpl(sourcesOnlineDataSource)
    }
}