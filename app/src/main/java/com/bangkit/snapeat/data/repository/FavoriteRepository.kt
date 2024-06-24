package com.bangkit.snapeat.data.repository

import com.bangkit.snapeat.data.api.ApiService
import javax.inject.Inject

class FavoriteRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getFavorites(userId: String) = apiService.getFavorites(userId)
}