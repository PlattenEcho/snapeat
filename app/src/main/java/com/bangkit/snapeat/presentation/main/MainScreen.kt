package com.bangkit.snapeat.presentation.main

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bangkit.snapeat.presentation.gapW
import com.bangkit.snapeat.presentation.gapW12
import com.bangkit.snapeat.presentation.gapW4
import com.bangkit.snapeat.presentation.navgraph.NavBarObject
import com.bangkit.snapeat.presentation.navgraph.NavGraph
import com.bangkit.snapeat.presentation.navgraph.Route
import com.bangkit.snapeat.ui.theme.Brown
import com.bangkit.snapeat.ui.theme.DarkBrown
import com.bangkit.snapeat.ui.theme.GrayOrange
import com.bangkit.snapeat.ui.theme.Orange

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        },
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
        NavBarObject.Add,
        NavBarObject.Favorite,
        NavBarObject.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val context = LocalContext.current.applicationContext
    val selected = remember{
        mutableStateOf(Icons.Default.Home)
    }

    BottomAppBar(
        backgroundColor = DarkBrown,
        modifier = Modifier
            .height(72.dp)
    ) {
        screens.forEachIndexed(){ index, screen ->
            if (index != 2 ){
                if (index == 3){
                    gapW(16)
                }
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController)
                if (index == 1){
                    gapW(16)
                }
            } else {
                FloatingActionButton(
                    shape = RoundedCornerShape(16.dp),
                    onClick = {

                    },
                    backgroundColor = Brown
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add icon",
                        tint = Orange)
                }
            }
        }
    }
}
@Composable
fun RowScope.AddItem(
    screen: NavBarObject,
    currentDestination: NavDestination?,
    navController: NavController
){
    val isSelected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true

    BottomNavigationItem(
        label = {
            Text(
                text = screen.title,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 12.sp
                ),
                color = if (isSelected) Orange else GrayOrange
            )
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = null,
                tint = if (isSelected) Orange else GrayOrange
            )
        },
        selected = isSelected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        alwaysShowLabel = false
    )
}