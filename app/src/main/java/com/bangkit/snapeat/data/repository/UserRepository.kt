package com.bangkit.snapeat.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.bangkit.snapeat.data.api.ApiService
import com.bangkit.snapeat.data.request.LoginRequest
import com.bangkit.snapeat.data.response.RegisterRequest

class UserRepository(private val apiService: ApiService,) {
    suspend fun registerUser(email: String, password: String, username: String) =
        apiService.registerUser(RegisterRequest(email, password, username))

    suspend fun loginUser(email: String, password: String) =
        apiService.loginUser(LoginRequest(email, password))

}
