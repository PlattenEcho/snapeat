package com.bangkit.snapeat.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun  HomeScreen() {
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
            text = "Halo, Bhaska! makan apa nih pagi ini?",
            color = Color.White,
            style = MaterialTheme.typography.displayMedium
        )

        gapH16
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            ) {
            listOf("Bubur Ayam", "Soto Lamongan", "Nasi Uduk", "Jus", "Roti", "Jajanan").forEach { item ->
                Button(
                    onClick = { /* TODO */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Brown2)
                ) {
                    Text(
                        text = item,
                        style = MaterialTheme.typography.bodySmall
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

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
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
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = place,
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    SnapEatTheme {
        HomeScreen()
    }
}