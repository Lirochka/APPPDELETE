package com.example.apppdelete

interface SourcesOnlineDataSource {

    suspend fun getSources(category: String): List<SourcesItemDTO?>?
}