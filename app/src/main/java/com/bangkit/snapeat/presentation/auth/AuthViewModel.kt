package com.bangkit.snapeat.presentation.auth

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.snapeat.data.repository.UserRepository
import com.bangkit.snapeat.data.response.LoginResponse
import com.bangkit.snapeat.domain.manager.LocalUserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val localUserManager: LocalUserManager
) : ViewModel() {

    var loginState by mutableStateOf<LoginState?>(null)
        private set

    var registerState by mutableStateOf<RegisterState?>(null)
        private set

    var snackbarMessage by mutableStateOf("")
    var isErrorSnackbar by mutableStateOf(false)

    fun registerUser(email: String, password: String, username: String) {
        viewModelScope.launch {
            try {
                val response = userRepository.registerUser(email, password, username)
                if (response.isSuccessful) {
                    registerState = RegisterState.Success
                    snackbarMessage = "Registration successful!"
                    isErrorSnackbar = false
                } else {
                    registerState = RegisterState.Error(response.message())
                    snackbarMessage = "Registration failed: ${response.message()}"
                    isErrorSnackbar = true
                }
            } catch (e: Exception) {
                registerState = RegisterState.Error(e.localizedMessage ?: "An unknown error occurred")
                snackbarMessage = "Registration failed: ${e.localizedMessage ?: "An unknown error occurred"}"
                isErrorSnackbar = true
            }
        }
    }

    fun loginUser(email: String, password: String) {
        Log.d("LoginResponse", "euy")
        viewModelScope.launch {
            try {
                Log.d("Masuk", "Hehe")
                val response = userRepository.loginUser(email, password)
                Log.d("LoginResponse", response.body().toString())

                if(response.isSuccessful) {
                    loginState = LoginState.Success(response.body()!!)
                    localUserManager.saveToken(response.body()!!.user.stsTokenManager.accessToken)
                    response.body()!!.user.providerData.first().let {
                        localUserManager.saveUserInformation(
                            response.body()!!.user.email,
                            response.body()!!.user.uid,
                            it.displayName ?: "No name",
                            it.photoURL ?: "https://www.pngitem.com/pimgs/m/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png"
                        )
                    }
                    snackbarMessage = "Login successful!"
                    isErrorSnackbar = false
                } else {
                    loginState = LoginState.Error(response.message())
                    snackbarMessage = "Login failed: ${response.message()}"
                    isErrorSnackbar = true
                }
            } catch (e: Exception) {
                loginState = LoginState.Error(e.localizedMessage ?: "An unknown error occurred")
                snackbarMessage = "Login failed: ${e.localizedMessage ?: "An unknown error occurred"}"
                isErrorSnackbar = true
            }
        }
    }
    sealed class RegisterState {
        object Success : RegisterState()
        data class Error(val message: String) : RegisterState()
    }

    sealed class LoginState {
        data class Success(val data: LoginResponse) : LoginState()
        data class Error(val message: String) : LoginState()
    }
}
