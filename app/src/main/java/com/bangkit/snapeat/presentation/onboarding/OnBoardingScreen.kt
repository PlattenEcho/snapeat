package com.bangkit.snapeat.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.bangkit.snapeat.presentation.Dimension.MediumPadding2
import com.bangkit.snapeat.presentation.common.CustomButton
import com.bangkit.snapeat.presentation.onboarding.components.OnBoardingPage
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    event: (OnBoardingEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()){

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
        ) {index ->
            Image(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
                    .fillMaxHeight(fraction = 0.7f),
                painter = painterResource(id = pages[index].image),
                contentDescription = null,
                contentScale = ContentScale.Crop)
        }
        OnBoardingPage(
            page = pages[pagerState.currentPage],
            selectedPage = pagerState.currentPage
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(MediumPadding2)
            .navigationBarsPadding(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val scope = rememberCoroutineScope()
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                text = buttonState.value[1]
            ) {
                scope.launch {
                    if (pagerState.currentPage == 3) {
//                            event(OnBoardingEvent.SaveAppEntry)

                    } else {
                        pagerState.animateScrollToPage(
                            page = pagerState.currentPage + 1
                        )
                    }
                }
            }
        }
    }
}