package com.alamin.tweesty

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.alamin.tweesty.ui.theme.TweestyTheme
import com.alamin.tweesty.view_model.TweetViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var tweetViewModel: TweetViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tweetViewModel = ViewModelProvider(this)[TweetViewModel::class.java]

        lifecycleScope.launch {
            tweetViewModel.categories.collect{
                Log.d(TAG, "onCreate: ${it.distinct()}}")
            }
        }

        setContent {
            TweestyTheme {

            }
        }
    }
}


