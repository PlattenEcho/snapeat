package com.bangkit.snapeat.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bangkit.snapeat.R
import com.bangkit.snapeat.presentation.common.FeedsCard
import com.bangkit.snapeat.presentation.gapH16
import com.bangkit.snapeat.presentation.gapH32
import com.bangkit.snapeat.presentation.gapH8
import com.bangkit.snapeat.presentation.gapW
import com.bangkit.snapeat.presentation.gapW4
import com.bangkit.snapeat.presentation.gapW8
import com.bangkit.snapeat.presentation.navgraph.NavBarObject
import com.bangkit.snapeat.ui.theme.Brown
import com.bangkit.snapeat.ui.theme.Brown2
import com.bangkit.snapeat.ui.theme.GrayBrown
import com.bangkit.snapeat.ui.theme.SnapEatTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun  HomeScreen(
    navController: NavController
) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Brown)
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Profile and Location
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Profile Picture
                Image(
                    painter = painterResource(id = R.drawable.bhaska),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)

                )
                gapW8
                Box(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(48.dp))
                        .background(Brown2)
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        gapW(2)
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color.White)
                        gapW4
                        Column {
                            Text(
                                text = "Tembalang, Semarang",
                                color = Color.White,
                                style = MaterialTheme.typography.bodySmall)
                            Text(
                                text = "Ubah Lokasi",
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodySmall)
                        }
                        gapW8
                    }

                }
            }

            gapH16
            Text(
                text = "Halo, Bhaska! Makan apa nih hari ini?",
                color = Color.White,
                style = MaterialTheme.typography.displayMedium
            )

            gapH16
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Hmm, coba sini  kali ya?",
                    color = Color.White,
                    style = MaterialTheme.typography.displaySmall.copy(
                        fontSize = 16.sp,
                    )
                )
            }
            gapH8
            Text(
                text = "Daripada bingung mending samperin tempat teman kamu",
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
                                painter = painterResource(id = R.drawable.fikim),
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

            gapH32
            Text(
                text = "Feeds",
                color = Color.White,
                style = MaterialTheme.typography.displaySmall.copy(
                    fontSize = 16.sp,
                )
            )
            gapH16
            FeedsCard()
            gapH16
            FeedsCard()
            gapH16
            FeedsCard()

        }
    }


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    SnapEatTheme {
        HomeScreen(rememberNavController())
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