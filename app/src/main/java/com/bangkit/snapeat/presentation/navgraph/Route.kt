package com.bangkit.snapeat.presentation.navgraph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object AuthScreen : Route(route = "authScreen")
    object LoginScreen : Route(route = "loginScreen")
    object RegisterScreen : Route (route = "registerScreen")
    object HomeScreen: Route(route = "homeScreen")
    object SearchScreen: Route(route = "searchScreen")
    object FavoriteScreen: Route(route = "favoriteScreen")
    object ProfileScreen: Route(route = "profileScreen")
    object MainScreen: Route(route = "mainScreen")
    object PostScreen: Route(route = "postScreen")

    object AppStartNavigation : Route(route = "appStartNavigation")
    object SnapEatNavigation : Route(route = "snapEatNavigation")
    object SnapEatNavigatorScreen: Route(route = "snapEatNavigatorScreen")
}