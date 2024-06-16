package com.bangkit.snapeat.presentation.main

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bangkit.snapeat.presentation.navgraph.NavBarObject
import com.bangkit.snapeat.presentation.navgraph.NavGraph
import com.bangkit.snapeat.presentation.navgraph.Route

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        val bottomPadding = innerPadding.calculateBottomPadding()
        NavGraph(navController = navController, startDestination = Route.HomeScreen.route)
    }
}


@Composable
fun BottomBar(navController: NavController){
    val screens = listOf(
        NavBarObject.Home,
        NavBarObject.Search,
        NavBarObject.Favorite,
        NavBarObject.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
    ) {
        screens.forEach{ screens ->
            AddItem(
                screen = screens,
                currentDestination = currentDestination,
                navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: NavBarObject,
    currentDestination: NavDestination?,
    navController: NavController
){
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = null)
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}