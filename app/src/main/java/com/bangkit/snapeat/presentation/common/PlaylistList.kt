package com.bangkit.snapeat.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bangkit.snapeat.R
import com.bangkit.snapeat.presentation.gapW12
import com.bangkit.snapeat.ui.theme.Brown2
import com.bangkit.snapeat.ui.theme.GrayBrown
import com.bangkit.snapeat.ui.theme.GrayOrange
import com.bangkit.snapeat.ui.theme.Orange
import com.bangkit.snapeat.ui.theme.SnapEatTheme
import com.bangkit.snapeat.ui.theme.WhiteGray


@Composable
fun PlaylistList(
    name: String = "Restaurant Name",
    rating: String = "4.5",
    ratingCount: String = "(1500)",
    img: Painter = painterResource(id = R.drawable.onboarding2),
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Brown2,
        ),
        shape = RoundedCornerShape(size = 6.dp),
    ){
        Row (
            horizontalArrangement = Arrangement.Center ,
        ){
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .height(95.dp)
                    .width(95.dp),
                painter = img,
                contentDescription = null )
            gapW12
            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.
                    labelMedium.copy(fontWeight = FontWeight.SemiBold))
                Text(
                    text = "$rating $ratingCount",
                    style = MaterialTheme.typography.labelSmall,
                    color = GrayBrown
                )
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PlaylistListPreview() {
    SnapEatTheme {
        PlaylistList(onClick = {})
    }
}