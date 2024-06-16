package com.bangkit.snapeat.presentation.login

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bangkit.snapeat.R
import com.bangkit.snapeat.presentation.Dimension
import com.bangkit.snapeat.presentation.common.CustomButton
import com.bangkit.snapeat.presentation.common.CustomEmailField
import com.bangkit.snapeat.presentation.common.CustomPasswordField
import com.bangkit.snapeat.presentation.common.CustomTextField
import com.bangkit.snapeat.presentation.gapH16
import com.bangkit.snapeat.presentation.gapH8
import com.bangkit.snapeat.presentation.navgraph.Route
import com.bangkit.snapeat.presentation.onboarding.components.OnBoardingPage
import com.bangkit.snapeat.presentation.onboarding.components.PageIndicator
import com.bangkit.snapeat.presentation.onboarding.pages
import com.bangkit.snapeat.ui.theme.Brown
import com.bangkit.snapeat.ui.theme.DarkBrown
import com.bangkit.snapeat.ui.theme.GrayBrown
import com.bangkit.snapeat.ui.theme.GrayOrange
import com.bangkit.snapeat.ui.theme.Orange
import com.bangkit.snapeat.ui.theme.SnapEatTheme
import com.google.android.material.bottomappbar.BottomAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Brown,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        text = "Login",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Brown),
        ) {
            val emailValue = remember { mutableStateOf(TextFieldValue()) }
            val passwordValue = remember { mutableStateOf(TextFieldValue()) }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Masuk menggunakan Email",
                modifier = Modifier.padding(horizontal = Dimension.MediumPadding2),
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Masukkan kredensial akun kamu untuk mulai menggunakan aplikasi",
                modifier = Modifier.padding(horizontal = Dimension.MediumPadding2),
                style = MaterialTheme.typography.bodyMedium,
                color = GrayBrown
            )
            gapH16
            CustomEmailField(
                emailValue = emailValue)
            gapH16
            CustomPasswordField(
                passwordValue = passwordValue)
            gapH16
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = "Login"
            ) {
                navController.navigate(Route.HomeScreen.route)
            }
            gapH16
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimension.MediumPadding2),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Lupa Password?",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Orange
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    SnapEatTheme {
        LoginScreen(rememberNavController(), onBackClick = {})
    }
}