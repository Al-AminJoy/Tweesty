package com.alamin.tweesty

import android.icu.text.MessagePattern.ArgType
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
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alamin.tweesty.screen.CategoryScreen
import com.alamin.tweesty.screen.DetailsScreen
import com.alamin.tweesty.ui.theme.TweestyTheme
import com.alamin.tweesty.view_model.TweetViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.reflect.Type
import javax.inject.Inject

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            TweestyTheme {
                App()
            }
        }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "category" ){
            composable(route="category"){
                CategoryScreen(navController)
            }
            composable(route= "details/{category}", arguments = listOf(
                navArgument("category"){
                    type= NavType.StringType
                }
            )){
                val categoryName = it.arguments!!.getString("category")
                DetailsScreen(categoryName!!)
            }
        }
    }

}


