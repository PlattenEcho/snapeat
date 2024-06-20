package com.bangkit.snapeat.presentation.favorite

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import com.bangkit.snapeat.R
import com.bangkit.snapeat.presentation.common.PlaylistCover
import com.bangkit.snapeat.presentation.common.PlaylistList
import com.bangkit.snapeat.presentation.gapH
import com.bangkit.snapeat.presentation.gapH16
import com.bangkit.snapeat.presentation.gapH32
import com.bangkit.snapeat.presentation.gapH8
import com.bangkit.snapeat.presentation.home.BottomBar
import com.bangkit.snapeat.ui.theme.Brown
import com.bangkit.snapeat.ui.theme.DarkBrown
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState




@Composable
fun FavoriteScreen(
    navController: NavController
) {
    val state = rememberCollapsingToolbarScaffoldState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {

        }
    ) { padding ->
        val re = padding
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Brown)
                    .padding(32.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Box(
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    PlaylistCover()
                }
            }
            Text(
                text = "@bbbb's Favourite",
                color = Color.White,
                style = MaterialTheme.typography.displaySmall.copy(
                    fontSize = 24.sp
                )
            )
            gapH16
            repeat(12) {
                PlaylistList(onClick = {})
                gapH16
            }
        }
    }
}