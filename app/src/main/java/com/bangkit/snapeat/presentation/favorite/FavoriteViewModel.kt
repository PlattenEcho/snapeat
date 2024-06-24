package com.bangkit.snapeat.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.snapeat.data.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val favoriteRepository: FavoriteRepository) : ViewModel() {
    fun getFavorites(userId: String) {
        viewModelScope.launch {
            val favorites = favoriteRepository.getFavorites(userId)
            // handle favorites

        }
    }


}