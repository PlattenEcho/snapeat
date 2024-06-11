package com.bangkit.snapeat.presentation.navgraph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object AuthScreen : Route(route = "authScreen")
    object LoginScreen : Route(route = "routeScreen")
    object RegisterScreen : Route (route = "RegisterScreen")
    object HomeScreen: Route(route = "homeScreen")
    object SearchScreen : Route(route = "searchScreen")


    object AppStartNavigation : Route(route = "appStartNavigation")
    object SnapEatNavigation : Route(route = "snapEatNavigation")
    object SnapEatNavigatorScreen: Route(route = "snapEatNavigatorScreen")
}