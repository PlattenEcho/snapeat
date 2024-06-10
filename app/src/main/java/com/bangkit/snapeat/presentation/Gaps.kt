package com.bangkit.snapeat.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun gapW(n: Int) = Spacer(modifier = Modifier.width(n.dp))

@Composable
fun gapH(n: Int) = Spacer(modifier = Modifier.height(n.dp))

val gapW4 @Composable get() = Spacer(modifier = Modifier.width(4.dp))
val gapW8 @Composable get() = Spacer(modifier = Modifier.width(8.dp))
val gapW12 @Composable get() = Spacer(modifier = Modifier.width(12.dp))
val gapW24 @Composable get() = Spacer(modifier = Modifier.width(24.dp))
val gapW32 @Composable get() = Spacer(modifier = Modifier.width(32.dp))
val gapW64 @Composable get() = Spacer(modifier = Modifier.width(64.dp))

val gapH4 @Composable get() = Spacer(modifier = Modifier.height(4.dp))
val gapH8 @Composable get() = Spacer(modifier = Modifier.height(8.dp))
val gapH12 @Composable get() = Spacer(modifier = Modifier.height(12.dp))
val gapH24 @Composable get() = Spacer(modifier = Modifier.height(24.dp))
val gapH32 @Composable get() = Spacer(modifier = Modifier.height(32.dp))
val gapH64 @Composable get() = Spacer(modifier = Modifier.height(64.dp))
