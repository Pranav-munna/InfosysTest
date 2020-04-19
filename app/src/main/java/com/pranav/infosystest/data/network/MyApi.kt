package com.pranav.infosystest.data.network

import com.pranav.infosystest.data.network.responses.NewsResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface MyApi {

     @GET("facts")
   suspend fun allNewsList(
    ): Response<NewsResponse>

    companion object{
        operator fun invoke():MyApi{
            return  Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }

}