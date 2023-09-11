package com.alamin.tweesty.screen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alamin.tweesty.models.Tweet
import com.alamin.tweesty.view_model.TweetViewModel

private const val TAG = "DetailsScreen"

@Composable
fun DetailsScreen(categoryName: String) {
    val tweetViewModel: TweetViewModel = hiltViewModel()
    tweetViewModel.getTweets(categoryName)
    val tweets = tweetViewModel.tweets.collectAsState()
    Log.d(TAG, "DetailsScreen: ${tweets.value}")
    LazyColumn(content = {
        items(tweets.value) {
            TweetListItem(tweet = it)
        }
    })
}

@Composable
fun TweetListItem(tweet: Tweet) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), border = BorderStroke(1.dp, color = Color.Red), colors = CardDefaults.cardColors(containerColor = Color(0xFF85E6FF))
    ) {
        Text(
            text = tweet.text,
            color = Color.White,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.titleLarge
        )
    }

}