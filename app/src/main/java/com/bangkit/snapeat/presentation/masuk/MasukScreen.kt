package com.bangkit.snapeat.presentation.masuk

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bangkit.snapeat.R
import com.bangkit.snapeat.presentation.Dimension
import com.bangkit.snapeat.presentation.login.LoginScreen
import com.bangkit.snapeat.ui.theme.DarkBrown
import com.bangkit.snapeat.ui.theme.SnapEatTheme

@Composable
fun MasukScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBrown)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Align to the bottom center
                .padding(16.dp)
        ) {
            Text(
                text = "Masuk",
                modifier = Modifier.padding(horizontal = Dimension.MediumPadding2),
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = colorResource(id = R.color.display_small)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Jadi Gini",
                modifier = Modifier.padding(horizontal = Dimension.MediumPadding2),
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_medium)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPageReview(){
    SnapEatTheme {
        MasukScreen()
    }
}