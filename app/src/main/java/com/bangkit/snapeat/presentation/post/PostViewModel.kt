package com.bangkit.snapeat.presentation.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.snapeat.data.repository.PostRepository
import com.bangkit.snapeat.data.request.PostRequest
import kotlinx.coroutines.launch
import java.io.File

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {
    fun addPost(userId: String, food: String, caption: String, location: String, image: File, rating: Int) {
        val postRequest = PostRequest(userId, food, caption, location, image, rating)
        viewModelScope.launch {
            val postResponse = postRepository.addPost(postRequest)
            // buatkan fungsi untuk push ke halaman dari detail post nya

        }
    }
}