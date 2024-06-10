package com.bangkit.snapeat.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination){
//        navigation(
//            route = Route.AppStartNavigation.route,
//            startDestination = Route.OnBoardingScreen.route
//        ){
//
//        }
    }
}