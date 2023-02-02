package com.example.shikiliteappcompose.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.shikiliteappcompose.domain.model.OnGoingListItem

@Composable
fun OnGoingItemComponent(
    onGoingItem: OnGoingListItem,
    modifier: Modifier = Modifier
) {
    Card(shape = RoundedCornerShape(10.dp), modifier = modifier.padding(10.dp)) {
        Column(modifier.padding(2.dp)) {

        Image(
            painter = rememberAsyncImagePainter(model = onGoingItem.thumbPath),
            contentDescription = null,
            modifier = modifier.size(128.dp)
        )

        Text(text = onGoingItem.titleName)
        }
    }
}