package com.bangkit.snapeat.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.bangkit.snapeat.R
import com.bangkit.snapeat.presentation.gapH4
import com.bangkit.snapeat.presentation.gapH8
import com.bangkit.snapeat.presentation.home.HomeScreen
import com.bangkit.snapeat.ui.theme.Brown
import com.bangkit.snapeat.ui.theme.DarkBrown
import com.bangkit.snapeat.ui.theme.GrayBrown
import com.bangkit.snapeat.ui.theme.SnapEatTheme
@Composable
fun PlaylistCover() {
    Box(
        modifier = Modifier
            .height(196.dp)
            .width(196.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, GrayBrown, RoundedCornerShape(16.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(Brown, DarkBrown)
                )
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.bhaska),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape)
            )
            gapH8
            Text(
                text = "Rekomendasi By",
                color = Color.White,
                style = MaterialTheme.typography.displaySmall.copy(
                    fontSize = 14.sp
                ),
            )
            Text(
                text = "@bhsk",
                color = Color.White,
                style = MaterialTheme.typography.displaySmall.copy(
                    fontSize = 16.sp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlaylistCoverPreview() {
    SnapEatTheme {
        PlaylistCover()
    }
}

