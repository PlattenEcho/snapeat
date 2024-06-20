package com.bangkit.snapeat.data.response

data class PostResponse (
    val postId: String,
    val userId: String,
    val username: String,
    val postImage: String,
    val postCaption: String,
    val postDate: String
)

data class LikeResponse (
    val postId: String,
    val userId: String,
    val likeCount: Int
)