package com.example.shikiliteappcompose.presentation.screens


import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shikiliteappcompose.presentation.screens.home.HomeScreenViewModel
import com.example.shikiliteappcompose.presentation.screens.home.OnGoingItemComponent
import dagger.hilt.android.AndroidEntryPoint
import com.example.shikiliteappcompose.R
import com.example.shikiliteappcompose.presentation.ui.theme.*


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Image(
        painter = painterResource(id = R.drawable.back),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()

    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(BackgroundColor))
    Column(
        Modifier
            .fillMaxSize()
            .padding(3.dp)
    )
    {

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Сейчас на экранах",
            color = TextColor,
            fontSize = 17.sp,
            modifier = Modifier
                .background(
                    color = BlockColor80,
                    shape = RoundedCornerShape(12.dp)
                )
                .fillMaxWidth()
                .height(28.dp)
                .padding(start = 14.dp)
                .wrapContentHeight()
        )
        Spacer(modifier = Modifier.height(2.dp))

        LazyRow(
            Modifier.fillMaxWidth()
        )
        {
            items(state.onGoingsList.size) { i ->
                val onGoing = state.onGoingsList[i]

                OnGoingItemComponent(onGoingItem = onGoing, modifier = Modifier)
            }
        }

        Text(
            text = "Недавно просмотренное",
            color = TextColor,
            fontSize = 17.sp,
            modifier = Modifier
                .background(
                    color = SkyBlue40,
                    shape = RoundedCornerShape(12.dp)
                )
                .fillMaxWidth()
                .height(28.dp)
                .padding(start = 14.dp)
                .wrapContentHeight()
        )




    }

}