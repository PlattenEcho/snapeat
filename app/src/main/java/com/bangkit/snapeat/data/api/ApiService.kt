package com.bangkit.snapeat.data.api

import com.bangkit.snapeat.data.response.LoginRequest
import com.bangkit.snapeat.data.response.LoginResponse
import com.bangkit.snapeat.data.response.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {
    @POST("users/register")
    suspend fun registerUser(@Body request: RegisterRequest): Response<Void>

    @POST("users/login")
    suspend fun loginUser(@Body request: LoginRequest): Response<LoginResponse>
}
