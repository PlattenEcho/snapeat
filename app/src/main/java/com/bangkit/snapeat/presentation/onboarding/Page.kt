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
        title = "Selamat Datang di SnapEat 🍽️",
        description = "Mulai eksplorasi makanan kamu dengan SnapEat",
        image = R.drawable.onboarding1
    ),

    Page(
        title = "Dapatkan rekomendasi restoran mu!",
        description = "Mulai eksplorasi makanan kamu dengan SnapEat",
        image = R.drawable.onboarding2
    ),

    Page(
        title = "Cari makan? Yuk lihat makanan terpopuler",
        description = "Mulai eksplorasi makanan kamu dengan SnapEat",
        image = R.drawable.onboarding3
    )
)
