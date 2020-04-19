package com.pranav.infosystest.data.repositories

import com.pranav.infosystest.data.network.MyApi
import com.pranav.infosystest.data.network.responses.NewsResponse
import retrofit2.Response

class NewsRepository {

    suspend fun news(): Response<NewsResponse> {
        return MyApi().allNewsList()
    }
}