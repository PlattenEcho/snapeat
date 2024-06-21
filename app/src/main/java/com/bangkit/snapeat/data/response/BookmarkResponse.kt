package com.bangkit.snapeat.data.response

data class BookmarkResponse (
    val bookmarks: List<BookmarkItem>
)

data class BookmarkItem (
    val id: String,
    val bookmarks: List<String>,
    val createdAt: String,
    val imageUrl: String,
    val rating: String,
    val bookmarkCount: Int,
    val caption: String,
    val location: String,
    val likeCount: Int,
    val userId: String,
    val food: String,
    val likes: List<String>
)