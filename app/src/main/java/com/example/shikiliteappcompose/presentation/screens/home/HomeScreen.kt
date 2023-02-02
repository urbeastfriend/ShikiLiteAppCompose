package com.example.shikiliteappcompose.presentation.screens


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shikiliteappcompose.presentation.screens.home.HomeScreenViewModel
import com.example.shikiliteappcompose.presentation.screens.home.OnGoingItemComponent

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)) {

        LazyRow(Modifier.fillMaxWidth()
        )
        {
            items(state.onGoingsList.size){
                i ->
                val onGoing = state.onGoingsList[i]


                OnGoingItemComponent(onGoingItem = onGoing, modifier = Modifier
                    .fillMaxWidth()
                    )
            }
        }

    }

}