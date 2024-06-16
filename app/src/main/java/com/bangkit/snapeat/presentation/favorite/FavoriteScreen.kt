package com.bangkit.snapeat.presentation.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bangkit.snapeat.presentation.home.BottomBar
import com.bangkit.snapeat.ui.theme.Brown


@Composable
fun FavoriteScreen (
    navController: NavController
){
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {innerPadding ->
        val bottomPadding = innerPadding.calculateBottomPadding()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Brown)
                .padding(bottom = bottomPadding, top = 20.dp, start = 20.dp, end = 20.dp)
        ) {
            Text(text = "FavoriteScreen")
        }
    }
}