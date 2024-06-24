package com.bangkit.snapeat.presentation.navgraph

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
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
import com.bangkit.snapeat.presentation.favorite.FavoriteScreen
import com.bangkit.snapeat.presentation.home.HomeScreen
import com.bangkit.snapeat.presentation.auth.login.LoginScreen
import com.bangkit.snapeat.presentation.main.MainScreen
import com.bangkit.snapeat.presentation.onboarding.OnBoardingScreen
import com.bangkit.snapeat.presentation.post.PostScreen
import com.bangkit.snapeat.presentation.profile.ProfileScreen
import com.bangkit.snapeat.presentation.auth.register.RegisterScreen
import com.bangkit.snapeat.presentation.search.SearchScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Route.OnBoardingScreen.route,

) {
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            EnterTransition.None
        },
        exitTransition = {
            ExitTransition.None
        }
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

        composable(
            route = Route.SearchScreen.route
        ){
            SearchScreen(navController = navController)
        }

        composable(
            route = Route.FavoriteScreen.route
        ){
            FavoriteScreen(navController = navController, viewModel = hiltViewModel())
        }

        composable(
            route = Route.ProfileScreen.route
        ){
            ProfileScreen(navController = navController)
        }

        composable(
            route = Route.MainScreen.route
        ) {
            MainScreen()
        }

        composable(
            route = Route.MainScreen.route
        ) {
            MainScreen()
        }

        composable(
            route = Route.PostScreen.route
        ) {
            PostScreen(navController, onBackClick = {navController.popBackStack()})
        }
    }
}