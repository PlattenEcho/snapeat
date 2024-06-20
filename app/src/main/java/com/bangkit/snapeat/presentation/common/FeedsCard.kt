package com.bangkit.snapeat.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bangkit.snapeat.R
import com.bangkit.snapeat.presentation.gapH16
import com.bangkit.snapeat.presentation.gapH4
import com.bangkit.snapeat.presentation.gapH8
import com.bangkit.snapeat.presentation.gapW4
import com.bangkit.snapeat.presentation.gapW8
import com.bangkit.snapeat.ui.theme.Brown
import com.bangkit.snapeat.ui.theme.Brown2
import com.bangkit.snapeat.ui.theme.DarkBrown
import com.bangkit.snapeat.ui.theme.GrayBrown
import com.bangkit.snapeat.ui.theme.SnapEatTheme

@Composable
fun FeedsCard() {
    var expanded by remember { mutableStateOf(false) }
    var liked by remember { mutableStateOf(false) }
    val caption = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id fermentum leo, nec pharetra elit. Donec luctus posuere egestas. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id fermentum leo, nec pharetra elit. Donec luctus posuere egestas."

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Brown2,
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bhaska), // Replace with your profile picture resource
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.White, CircleShape)
                )
                gapW8
                Column {
                    Text(
                        text = "Bhaska",
                        color = Color.White,
                        style = MaterialTheme.typography.displaySmall.copy(
                            fontSize = 16.sp
                        ),
                    )
                    Text(
                        text = "12 menit yang lalu",
                        color = GrayBrown, // Semi-transparent white
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 12.sp
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                TextButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Brown,
                        contentColor = Color.White
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = null
                    )
                    gapW4
                    Text(
                        text = "Jakarta Timur",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            // Food Image
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(Color.DarkGray)
                    .size(height = 330.dp, width = 330.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                // Place Image
                Image(
                    painter = painterResource(id = R.drawable.onboarding1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .wrapContentWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .drawWithCache {
                            val gradient = Brush.verticalGradient(
                                colors = listOf(Color.Black, Color.Transparent),
                                startY = 350.dp.toPx(),
                                endY = (350.dp.toPx()) / 3
                            )
                            onDrawWithContent {
                                drawContent()
                                drawRect(gradient, blendMode = BlendMode.Multiply)
                            }
                        }
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
                ) {
                    Text(
                        text = "Tacos Akbar",
                        color = Color.White,
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Nachos, Salad",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                        )
                    }
                    gapH4
                    LazyRow {
                        items(5) {
                            Icon(
                                modifier = Modifier
                                    .size(26.dp),
                                imageVector = Icons.Filled.Star,
                                contentDescription = null,
                                tint = Color.White,
                            )
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                gapH8
                // Caption
                val textLines = remember(caption) {
                    caption.split("\n")
                }
                val shouldShowCollapsible = textLines.size > 2

                if (shouldShowCollapsible) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(if (expanded) Dp.Unspecified else 48.dp) // Change height based on state
                    ) {
                        Text(
                            text = caption,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 14.sp,
                            maxLines = if (expanded) Int.MAX_VALUE else 2, // Limit lines based on state
                            overflow = TextOverflow.Ellipsis // Add ellipsis when text is truncated
                        )
                    }
                    // IconButton Collapse
                    IconButton(
                        onClick = { expanded = !expanded },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Icon(
                            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                            contentDescription = null,
                            tint = GrayBrown
                        )
                    }
                } else {
                    Text(
                        text = caption,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 14.sp,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                HorizontalDivider(color = GrayBrown)
                gapH8
                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 12.dp, bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { liked = !liked }
                    ) {
                        Icon(
                            imageVector = if (liked) Icons.Filled.ThumbUp else Icons.Outlined.ThumbUp,
                            contentDescription = "Like Icon",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "15",
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedsCardPreview() {
    SnapEatTheme {
        FeedsCard()
    }
}
