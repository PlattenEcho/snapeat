package com.bangkit.snapeat

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.snapeat.domain.usecases.AppEntryUseCases
import com.bangkit.snapeat.presentation.navgraph.Route
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {

//    var splashCondition by mutableStateOf(true)
//        private set
//
//    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
//        private set
//
//    init{
//        appEntryUseCases.readAppEntry().onEach{shouldStartFromHomeScreen ->
//            if(shouldStartFromHomeScreen){
//
//            }else{
//
//            }
//            delay(300)
//            splashCondition = false
//        }.launchIn(viewModelScope)
//    }

}