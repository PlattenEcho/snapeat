package com.bangkit.snapeat.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.bangkit.snapeat.presentation.auth.AuthScreen
import com.bangkit.snapeat.presentation.home.HomeScreen
import com.bangkit.snapeat.presentation.login.LoginScreen
import com.bangkit.snapeat.presentation.onboarding.OnBoardingScreen
import com.bangkit.snapeat.presentation.register.RegisterScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Route.OnBoardingScreen.route,
) {
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = Route.OnBoardingScreen.route
        ){
            OnBoardingScreen(navController)
        }
        composable(
            route = Route.AuthScreen.route
        ) {
            AuthScreen(navController)
        }
        composable(
            route = Route.LoginScreen.route
        ) {
            LoginScreen(navController, onBackClick = {navController.popBackStack()})
        }
        composable(
            route = Route.RegisterScreen.route
        ) {
            RegisterScreen(navController, onBackClick = {navController.popBackStack()})
        }

        composable(
            route = Route.HomeScreen.route
        ){
            HomeScreen(navController)
        }
    }
}