package com.example.apppdelete

import java.lang.Exception
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(val newsOnlineDataSource: NewsOnlineDataSource) : NewsRepo {
    override suspend fun getNewsBySource(
        source: SourcesItemDTO,
        query: String?
    ): List<ArticlesItemDTO?>? {

        try {

            var result = newsOnlineDataSource.getNewsBySource(source, query ?: "")

            return result

        } catch (ex: Exception) {
            throw ex
        }
    }
}