package com.bangkit.snapeat.util

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color

@Composable
fun rememberSnackbarHostState(): SnackbarHostState {
    return remember { SnackbarHostState() }
}

fun showSnackbar(
    coroutineScope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    message: String,
    isError: Boolean = false,
    duration: SnackbarDuration = SnackbarDuration.Short
) {
    coroutineScope.launch {
        snackbarHostState.showSnackbar(
            message = message,
            duration = duration
        )
    }
}

@Composable
fun CustomSnackbarHost(snackbarHostState: SnackbarHostState) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { data ->
            val backgroundColor = if (data.visuals.message.contains("success", true)) {
                Color(0xFF4CAF50)
            } else {
                Color(0xFFF44336)
            }
            Snackbar(
                containerColor = backgroundColor,
                contentColor = Color.White
            ) {
                Text(data.visuals.message)
            }
        }
    )
}


