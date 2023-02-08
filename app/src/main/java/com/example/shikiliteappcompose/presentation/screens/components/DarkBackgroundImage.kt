package com.example.shikiliteappcompose.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.shikiliteappcompose.R
import com.example.shikiliteappcompose.presentation.ui.theme.BackgroundColor

@Composable
fun DarkBackgroundImage(
    imageId: Int,
    backgroundColor: androidx.compose.ui.graphics.Color,
    modifier: Modifier
) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxSize()

    )
    Box(modifier = modifier
        .fillMaxSize()
        .background(backgroundColor))
}