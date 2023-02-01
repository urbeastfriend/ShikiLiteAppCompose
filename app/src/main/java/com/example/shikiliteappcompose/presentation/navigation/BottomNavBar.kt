package com.example.shikiliteappcompose.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavBar(
    val route: String,
    var title: String,
    val icon: ImageVector
) {
    object Home: BottomNavBar(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object WatchList: BottomNavBar(
        route = "watchlist",
        title = "Watchlist",
        icon = Icons.Default.Bookmark
    )

    object History: BottomNavBar(
        route = "history",
        title = "History",
        icon = Icons.Default.History
    )

    object Settings: BottomNavBar(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}
