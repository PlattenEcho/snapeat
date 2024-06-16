package com.bangkit.snapeat.presentation.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bangkit.snapeat.presentation.Dimension.MediumPadding2
import com.bangkit.snapeat.presentation.common.CustomButton
import com.bangkit.snapeat.presentation.gapW8
import com.bangkit.snapeat.presentation.navgraph.Route
import com.bangkit.snapeat.presentation.onboarding.components.OnBoardingPage
import com.bangkit.snapeat.ui.theme.Brown
import com.bangkit.snapeat.ui.theme.SnapEatTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brown)
    ){

        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember{
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(2f / 3f)
                .fillMaxWidth()
        ) { index ->
            Image(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painterResource(id = pages[index].image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .weight(1f / 3f)
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .padding(bottom = 16.dp)
                .navigationBarsPadding()
                .background(Brown),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            OnBoardingPage(
                page = pages[pagerState.currentPage],
                selectedPage = pagerState.currentPage,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomButton(
                    text = buttonState.value[1],
                    modifier = Modifier.weight(1f),
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == pages.size - 1) {
                                navController.navigate(Route.AuthScreen.route)
                            } else {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPageReview(){
    SnapEatTheme {
        OnBoardingScreen(rememberNavController())
    }
}