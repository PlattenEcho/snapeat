package com.bangkit.snapeat.presentation.navgraph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavBarObject(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: NavBarObject(
        route = "homeScreen",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Search: NavBarObject(
        route = "searchScreen",
        title = "Search",
        icon = Icons.Default.Search
    )

    object Favorite: NavBarObject(
        route = "favoriteScreen",
        title = "Favorite",
        icon = Icons.Default.Favorite
    )

    object Profile: NavBarObject(
        route = "profileScreen",
        title = "Profile",
        icon = Icons.Default.Person
    )
}