package com.bangkit.snapeat.presentation.auth.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bangkit.snapeat.presentation.Dimension
import com.bangkit.snapeat.presentation.common.CustomButton
import com.bangkit.snapeat.presentation.onboarding.pages
import com.bangkit.snapeat.ui.theme.Brown
import com.bangkit.snapeat.ui.theme.DarkBrown
import com.bangkit.snapeat.ui.theme.SnapEatTheme

@Composable
fun AuthPage(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier
        .background(DarkBrown)
    ){
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Masuk untuk Melanjutkan",
            modifier = Modifier.padding(horizontal = Dimension.MediumPadding2),
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Masuk menggunakan email atau media sosial yang kamu punya",
            modifier = Modifier.padding(horizontal = Dimension.MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimension.MediumPadding2)
                .navigationBarsPadding()
        ) {
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Masuk") {
            }
            Spacer(modifier = Modifier.height(8.dp))
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Daftar",
                buttonColor = Brown ) {

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPageReview(){
    SnapEatTheme {
        AuthPage()
    }
}