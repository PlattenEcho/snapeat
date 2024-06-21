package com.bangkit.snapeat.data.repository

import android.util.Log
import com.bangkit.snapeat.data.api.ApiService
import com.bangkit.snapeat.data.request.PostRequest
import com.bangkit.snapeat.data.response.PostResponse
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun addPost(postRequest: PostRequest): PostResponse? {
        val response = apiService.addPost(postRequest)
        return if (response.isSuccessful) {
            Log.d("PostRepository", "addPost: ${response.body()}")
            response.body()
        } else {
            null
        }
    }
}