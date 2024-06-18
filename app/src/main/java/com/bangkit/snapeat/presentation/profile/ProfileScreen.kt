package com.bangkit.snapeat.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bangkit.snapeat.R
import com.bangkit.snapeat.presentation.gapH
import com.bangkit.snapeat.presentation.gapH12
import com.bangkit.snapeat.presentation.gapH16
import com.bangkit.snapeat.presentation.gapH8
import com.bangkit.snapeat.presentation.home.BottomBar
import com.bangkit.snapeat.presentation.register.RegisterScreen
import com.bangkit.snapeat.ui.theme.Brown
import com.bangkit.snapeat.ui.theme.GrayBrown
import com.bangkit.snapeat.ui.theme.SnapEatTheme
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen (
    navController: NavController
){
    val state = rememberCollapsingToolbarScaffoldState()

    CollapsingToolbarScaffold(
        modifier = Modifier
            .fillMaxSize(),
        state = state,
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {
            Box(
                modifier = Modifier
                    .background(Color.DarkGray)
            ){
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                        .drawWithCache {
                            val gradient = Brush.verticalGradient(
                                colors = listOf(Brown, Color.Transparent),
                                startY = 320.dp.toPx(),
                                endY = (320.dp.toPx()) / 3
                            )
                            onDrawWithContent {
                                drawContent()
                                drawRect(gradient)
                            }
                        },
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.profile_bg),
                    contentDescription =null
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bhaska),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(96.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.White, CircleShape)

                    )
                    gapH8
                    Text(
                        text = "Muhammad Bhaska",
                        color = Color.White,
                        style = MaterialTheme.typography.displaySmall.copy(
                        )
                    )
                    Text(
                        text = "@bhsk",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium.copy(
                        )
                    )
                }
            }
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Brown)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            gapH(20)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Rekomendasi Diberikan",
                    color = Color.White,
                    style = MaterialTheme.typography.displaySmall.copy(
                        fontSize = 16.sp,
                    )
                )
                Text(
                    text = "10",
                    color = Color.White,
                    style = MaterialTheme.typography.displaySmall.copy(
                        fontSize = 14.sp
                    )
                )
            }
            gapH16
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Teman",
                    color = Color.White,
                    style = MaterialTheme.typography.displaySmall.copy(
                        fontSize = 16.sp,
                    )
                )
                Text(
                    text = "54",
                    color = Color.White,
                    style = MaterialTheme.typography.displaySmall.copy(
                        fontSize = 14.sp
                    )
                )
            }
            gapH16
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Hmm, makan sini lagi kali ya?",
                    color = Color.White,
                    style = MaterialTheme.typography.displaySmall.copy(
                        fontSize = 16.sp,
                    )
                )
                Text(
                    text = "Lihat lainnya",
                    color = GrayBrown,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp
                    )
                )
            }
            gapH8
            Text(
                text = "Daripada bingung mending samperin tempat favorit kamu",
                color = Color.White.copy(alpha = 0.75f),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 12.sp
                )
            )

            gapH16
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .layout() { measurable, constraints ->
                        val placeable = measurable.measure(
                            constraints.copy(
                                maxWidth = constraints.maxWidth + 40.dp.roundToPx(), //add the end padding 16.dp
                            )
                        )
                        layout(placeable.width, placeable.height) {
                            placeable.place(0, 0)
                        }
                    }
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        end = 20.dp
                    ),
                    modifier = Modifier.clipToBounds()
                ) {
                    items(listOf(
                        "Gado Gado Bu Risma",
                        "Spaghetti Qiu Pasta",
                        "Gado Gado Bu Risma",
                        "Spaghetti Qiu Pasta",
                        "Gado Gado Bu Risma",
                        "Spaghetti Qiu Pasta")) { place ->
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(16.dp))
                                .background(Color.DarkGray)
                                .size(height = 150.dp, width = 120.dp)
                        ) {
                            // Place Image
                            Image(
                                painter = painterResource(id = R.drawable.onboarding2),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .drawWithCache {
                                        val gradient = Brush.verticalGradient(
                                            colors = listOf(Color.Black, Color.Transparent),
                                            startY = 150.dp.toPx(),
                                            endY = (150.dp.toPx()) / 3
                                        )
                                        onDrawWithContent {
                                            drawContent()
                                            drawRect(gradient, blendMode = BlendMode.Multiply)
                                        }
                                    }
                            )
                            Text(
                                text = place,
                                color = Color.White,
                                style = MaterialTheme.typography.bodySmall.copy(
                                    lineHeight = 16.sp,
                                    fontSize = 12.sp
                                ),
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
                            )
                        }
                    }
                }
            }
            Text(
                text = "Item ",
                modifier = Modifier.padding(32.dp)
            )
            Text(
                text = "Item ",
                modifier = Modifier.padding(32.dp)
            )
            Text(
                text = "Item ",
                modifier = Modifier.padding(32.dp)
            )
            Text(
                text = "Item ",
                modifier = Modifier.padding(32.dp)
            )
            Text(
                text = "Item ",
                modifier = Modifier.padding(32.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    SnapEatTheme {
        ProfileScreen(rememberNavController())
    }
}