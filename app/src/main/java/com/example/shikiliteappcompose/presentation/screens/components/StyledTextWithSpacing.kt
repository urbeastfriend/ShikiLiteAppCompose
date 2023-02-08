package com.example.shikiliteappcompose.presentation.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shikiliteappcompose.presentation.ui.theme.TextColor

@Composable
fun StyledTextWithSpacing(
    stringId: Int,
    backgroundColor: Color,
    modifier: Modifier
) {
    Text(
        text = stringResource(id = stringId),
        color = TextColor,
        fontSize = 17.sp,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .fillMaxWidth()
            .height(28.dp)
            .padding(start = 14.dp)
            .wrapContentHeight()
    )

    Spacer(modifier = modifier.height(2.dp))
}