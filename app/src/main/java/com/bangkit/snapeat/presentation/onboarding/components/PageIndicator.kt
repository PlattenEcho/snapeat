package com.bangkit.snapeat.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.bangkit.snapeat.presentation.Dimension.IndicatorSize
import com.bangkit.snapeat.ui.theme.BlueGray
import com.bangkit.snapeat.ui.theme.GrayOrange

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = GrayOrange
){
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween){
        repeat(pageSize){page->
            Box(modifier = Modifier.size(IndicatorSize).clip(CircleShape)
                .background(color = if (page == selectedPage) selectedColor else unselectedColor)
            )

        }
    }
}