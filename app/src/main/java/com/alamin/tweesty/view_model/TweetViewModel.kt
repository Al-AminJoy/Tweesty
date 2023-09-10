package com.alamin.tweesty.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alamin.tweesty.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetViewModel @Inject constructor(val repository:TweetRepository):ViewModel() {

    val categories = repository.category

    val tweets = repository.tweets

    init {
        getCategories()
    }


    private fun getCategories(){
        viewModelScope.launch {
            repository.getCategories()
        }
    }

    fun getTweets(category:String){
        viewModelScope.launch {
            repository.getTweets(category)
        }
    }


}