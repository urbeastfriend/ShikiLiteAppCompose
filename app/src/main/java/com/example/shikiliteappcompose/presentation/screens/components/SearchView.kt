package com.example.shikiliteappcompose.presentation.screens.components

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon

import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Text
import androidx.compose.ui.res.stringResource
import com.example.shikiliteappcompose.R
import com.example.shikiliteappcompose.presentation.ui.theme.SearchViewBackgroundColor
import com.example.shikiliteappcompose.presentation.ui.theme.TextColor

@Composable
fun SearchView(
    modifier: Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        maxLines = 1,
        textStyle = TextStyle(fontSize = 14.sp),
        label = { Text(text = stringResource(id = R.string.Search))},
        leadingIcon = { Icon(Icons.Filled.Search, null, tint = TextColor) },
        modifier = modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = Color.DarkGray,
            textColor = TextColor,

        )
    )
}