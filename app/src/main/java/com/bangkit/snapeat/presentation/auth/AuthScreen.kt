package com.bangkit.snapeat.presentation.auth

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.bangkit.snapeat.presentation.Dimension
import com.bangkit.snapeat.presentation.auth.components.AuthPage
import com.bangkit.snapeat.presentation.common.CustomButton
import com.bangkit.snapeat.presentation.onboarding.components.OnBoardingPage
import com.bangkit.snapeat.presentation.onboarding.pages
import com.bangkit.snapeat.ui.theme.Brown
import com.bangkit.snapeat.ui.theme.SnapEatTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AuthScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brown)
    ) {
        AuthPage(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview(){
    SnapEatTheme {
        AuthScreen()
    }
}