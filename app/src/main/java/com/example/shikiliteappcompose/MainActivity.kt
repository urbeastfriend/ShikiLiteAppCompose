package com.example.shikiliteappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.example.shikiliteappcompose.ui.theme.ShikiLiteAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShikiLiteAppComposeTheme {
                BoxWithTextInTheMiddle("Pepega")

            }
        }
    }
}


@Composable
fun BoxWithTextInTheMiddle(text: String) {
    ShikiLiteAppComposeTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)

        )
        {
            Text(modifier = Modifier.align(Alignment.Center), text = "$text", fontSize = 25.sp)
        }
    }
}