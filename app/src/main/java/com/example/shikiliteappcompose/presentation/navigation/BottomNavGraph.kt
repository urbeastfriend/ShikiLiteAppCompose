package com.example.shikiliteappcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shikiliteappcompose.presentation.navigation.BottomNavBar
import com.example.shikiliteappcompose.presentation.screens.HistoryScreen
import com.example.shikiliteappcompose.presentation.screens.HomeScreen
import com.example.shikiliteappcompose.presentation.screens.SettingsScreen
import com.example.shikiliteappcompose.presentation.screens.WatchListScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomNavBar.Home.route
    ){
        composable(route = BottomNavBar.Home.route){
            HomeScreen()
        }
        composable(route = BottomNavBar.WatchList.route){
            WatchListScreen()
        }
        composable(route = BottomNavBar.History.route){
            HistoryScreen()
        }
        composable(route = BottomNavBar.Settings.route){
            SettingsScreen()
        }
    }
}