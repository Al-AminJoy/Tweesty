package com.alamin.tweesty.repository

import android.util.Log
import com.alamin.tweesty.models.Tweet
import com.alamin.tweesty.network.APIInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

private const val TAG = "TweetRepository"
class TweetRepository @Inject constructor(private val apiInterface:APIInterface) {

    private val _category = MutableStateFlow<List<String>>(emptyList())
    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())

    val category = _category.asStateFlow()
    val tweets = _tweets.asStateFlow()

    suspend fun getCategories(){
        val response = apiInterface.getCategories()

        if (response.isSuccessful && response.body() != null){
            _category.emit(response.body()!!)
        }

    }

    suspend fun getTweets(category:String){
        val response = apiInterface.getTweets()
        if (response.isSuccessful && response.body() != null){
            Log.d(TAG, "getTweets: ${response.body()}")
            _tweets.emit(response.body()!!.tweets.filter { it.category.equals(category,ignoreCase = true) })
        }

    }

}