package com.bangkit.snapeat.data.request

import java.io.File

data class PostRequest (
    val userId: String,
    val food: String,
    val caption: String,
    val location: String,
    val image: File,
    val rating: Int
)