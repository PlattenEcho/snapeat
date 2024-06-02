package com.bangkit.snapeat.presentation.onboarding

import androidx.annotation.DrawableRes
import com.bangkit.snapeat.R

data class Page(
    val title:String,
    val description: String,
    @DrawableRes val image:Int
)

val pages = listOf(
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy Lorem Ipsum is simply dummy",
        image = R.drawable.onboarding1
    ),

    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy Lorem Ipsum is simply dummy",
        image = R.drawable.onboarding2
    ),

    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy Lorem Ipsum is simply dummy",
        image = R.drawable.onboarding3
    )
)
