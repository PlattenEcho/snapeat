package com.bangkit.snapeat.presentation.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bangkit.snapeat.R
import com.bangkit.snapeat.presentation.home.BottomBar
import com.bangkit.snapeat.ui.theme.Brown
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState


@Composable
fun FavoriteScreen (
    navController: NavController
){
    val state = rememberCollapsingToolbarScaffoldState()

    CollapsingToolbarScaffold(
        modifier = Modifier
            .fillMaxSize(),
        state = state,
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {
            val textSize = (18 + (30 - 18) * state.toolbarState.progress).sp

            Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .fillMaxWidth()
                    .height(150.dp)
                    .pin()
            )

            Text(
                text = "Title",
                modifier = Modifier
                    .road(Alignment.CenterStart, Alignment.BottomEnd)
                    .padding(60.dp, 16.dp, 16.dp, 16.dp),
                color = Color.White,
                fontSize = textSize
            )

            Image(
                modifier = Modifier
                    .pin()
                    .padding(16.dp),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(100) {
                Text(
                    text = "Item $it",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.5f)
                .background(MaterialTheme.colors.secondary)
                .height(40.dp)
        )
    }
}