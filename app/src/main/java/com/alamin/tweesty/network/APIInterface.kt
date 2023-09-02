package com.alamin.tweesty.network

import com.alamin.tweesty.models.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface APIInterface {
    @GET("v3/b/64b3dd858e4aa6225ebf1315?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category:String):Response<List<Tweet>>

    @GET("v3/b/64b3dd858e4aa6225ebf1315?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories(): Response<List<String>>

}