package com.example.shikiliteappcompose.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.presentation.ui.theme.TextColor

@Composable
fun ImageWithDescription(
    imagePath: String,
    descriptionText: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(10.dp).width(125.dp)) {


        Image(
            painter = rememberAsyncImagePainter(model = imagePath),
            contentScale = ContentScale.Crop,
            contentDescription = null, modifier = modifier.clip(RoundedCornerShape(10.dp)).height(200.dp).width(125.dp)
        )

        Text(
            text = descriptionText,
            maxLines = 1,
            textAlign = TextAlign.Center,
            color = TextColor,
            overflow = TextOverflow.Ellipsis
        )
    }
}