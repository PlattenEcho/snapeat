package com.bangkit.snapeat.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.bangkit.snapeat.R
import com.bangkit.snapeat.presentation.gapH16
import com.bangkit.snapeat.presentation.gapH4
import com.bangkit.snapeat.presentation.gapH8
import com.bangkit.snapeat.presentation.gapW
import com.bangkit.snapeat.presentation.gapW4
import com.bangkit.snapeat.presentation.gapW8
import com.bangkit.snapeat.presentation.login.LoginScreen
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
            text = "Halo, Bhaska! Makan apa nih pagi ini?",
            color = Color.White,
            style = MaterialTheme.typography.displayMedium
        )

        gapH16
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            ) {
            listOf("Bubur Ayam", "Soto Lamongan", "Nasi Uduk", "Jus", "Roti", "Susu").forEach { item ->
                Button(
                    onClick = { /* TODO */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Brown2)
                ) {
                    Text(
                        text = item,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )
                }
            }
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
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    SnapEatTheme {
        HomeScreen(rememberNavController())
    }
}