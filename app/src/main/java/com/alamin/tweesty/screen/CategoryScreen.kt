package com.alamin.tweesty.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alamin.tweesty.view_model.TweetViewModel

@Composable
fun CategoryScreen(navController: NavController) {
    val tweetViewModel: TweetViewModel = hiltViewModel()

    val categories = tweetViewModel.categories.collectAsState()

    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(2.dp), verticalArrangement = Arrangement.SpaceBetween){
        items(categories.value.distinct()){
            CategoryItem(it,navController)
        }
    }
}

@Composable
fun CategoryItem(category: String, navController: NavController) {
    Box(modifier = Modifier
        .padding(4.dp)
        .size(160.dp).clickable {
            navController.navigate("details/${category}")
        }.background(color = Color.DarkGray)){
        Text(text = category.uppercase(), modifier = Modifier.align(Alignment.Center), color = Color.White)
    }
}