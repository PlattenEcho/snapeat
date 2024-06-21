package com.bangkit.snapeat.data.response

data class ProfileResponse (
    val profilePicture: String,
    val password: String,
    val friendCount: Int,
    val email: String,
    val username: String,
    val posts: List<PostResponse>
)