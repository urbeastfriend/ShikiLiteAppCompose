package com.example.shikiliteappcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.shikiliteappcompose.MainScreen
import com.example.shikiliteappcompose.presentation.ui.theme.ShikiLiteAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShikiLiteAppComposeTheme {
                MainScreen()
            }
        }
    }
}


