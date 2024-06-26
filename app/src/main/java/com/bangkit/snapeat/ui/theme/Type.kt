package com.bangkit.snapeat.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bangkit.snapeat.R

val plusjakartasans = FontFamily(
    fonts = listOf(
        Font(R.font.plusjakartasans_regular, FontWeight.Normal),
        Font(R.font.plusjakartasans_bold, FontWeight.Bold),
        Font(R.font.plusjakartasans_semibold, FontWeight.SemiBold),
        Font(R.font.plusjakartasans_medium, FontWeight.Medium),
        )
)

// Set of Material typography styles to start with
// body is "Text" in the Figma Design
// label small is xsmall in Figma Design
val Typography = Typography(
    displaySmall = TextStyle(
        fontSize = 24.sp,
        fontFamily = plusjakartasans,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.sp,
    ),
    displayMedium = TextStyle(
        fontSize = 28.sp,
        fontFamily = plusjakartasans,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.sp,
    ),
    bodySmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = plusjakartasans,
        fontWeight = FontWeight.Normal,
        lineHeight = 21.sp,
    ),
    bodyMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = plusjakartasans,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
    ),
    labelSmall = TextStyle(
        fontSize = 13.sp,
        fontFamily = plusjakartasans,
        fontWeight = FontWeight.Normal,
        lineHeight = 19.sp,
    ),
    labelMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = plusjakartasans,
        fontWeight = FontWeight.Normal,
        lineHeight = 19.sp,
    ),
)