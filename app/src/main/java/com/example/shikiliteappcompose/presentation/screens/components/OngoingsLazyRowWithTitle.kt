package com.example.shikiliteappcompose.presentation.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shikiliteappcompose.R
import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.presentation.screens.home.ImageWithDescription
import com.example.shikiliteappcompose.presentation.ui.theme.BlockColor80
import com.example.shikiliteappcompose.presentation.ui.theme.TextColor

@Composable
fun OngoingsLazyRowWithTitle(
    titleTextId: Int,
    titleBackgroundColor: Color,
    ongoings :List<OnGoingListItem>,
    modifier: Modifier

) {

    StyledTextWithSpacing(stringId = titleTextId, backgroundColor = titleBackgroundColor, modifier = modifier)

    LazyRow(
        modifier.fillMaxWidth()
    )
    {
        items(ongoings.size) { i ->
            val onGoing = ongoings[i]

            ImageWithDescription(imagePath = onGoing.thumbPath, descriptionText = onGoing.titleName, modifier = Modifier)
        }
    }
}