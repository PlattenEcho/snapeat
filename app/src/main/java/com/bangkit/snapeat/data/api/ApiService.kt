package com.bangkit.snapeat.data.api

import com.bangkit.snapeat.data.request.PostRequest
import com.bangkit.snapeat.data.response.BookmarkResponse
import com.bangkit.snapeat.data.response.FriendResponse
import com.bangkit.snapeat.data.response.LikeResponse
import com.bangkit.snapeat.data.response.LoginRequest
import com.bangkit.snapeat.data.response.LoginResponse
import com.bangkit.snapeat.data.response.PostResponse
import com.bangkit.snapeat.data.response.ProfileResponse
import com.bangkit.snapeat.data.response.RegisterRequest
import com.bangkit.snapeat.data.response.SearchResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiService {
    @POST("users/register")
    suspend fun registerUser(@Body request: RegisterRequest): Response<Void>

    @POST("users/login")
    suspend fun loginUser(@Body request: LoginRequest): Response<LoginResponse>

    @POST("posts")
    suspend fun addPost(@Body request: PostRequest): Response<PostResponse>

    @POST("posts/{id}/like")
    suspend fun likePost(@Path("id") id: String): Response<LikeResponse>

    @GET("users/search/{id}")
    suspend fun searchUser(@Path("id") id: String): Response<SearchResponse>

    @POST("users/addFriend/{id}")
    suspend fun addFriend(@Path("id") id: String): Response<FriendResponse>

    @GET("users/{id}/bio")
    suspend fun getBio(@Path("id") id: String): Response<ProfileResponse>

    @GET("users/{id}/favorites")
    suspend fun getFavorites(@Path("id") id: String): Response<List<BookmarkResponse>>


}
