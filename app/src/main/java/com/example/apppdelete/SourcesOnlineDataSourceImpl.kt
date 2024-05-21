package com.example.apppdelete

import android.provider.SyncStateContract
import com.example.apppdelete.Utils.convertToDTOClass
import java.lang.Exception
import javax.inject.Inject

class SourcesOnlineDataSourceImpl @Inject constructor(val wepServices: WepServices) : SourcesOnlineDataSource {
    override suspend fun getSources(category: String): List<SourcesItemDTO?>? {

        try {
            var result = wepServices.getNewsSources(Constants.apiKey, category)

            return result.convertToDTOClass(SourcesResponseDTO::class.java).sources

        } catch (ex: Exception) {
            throw ex
        }
    }
}