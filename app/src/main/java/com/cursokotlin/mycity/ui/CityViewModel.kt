package com.cursokotlin.mycity.ui

import androidx.lifecycle.ViewModel
import com.cursokotlin.mycity.data.LocalPlaceProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CityViewModel:ViewModel() {

    private val _uiState= MutableStateFlow(CityUiState())
    val uiState:StateFlow<CityUiState> =_uiState


    init{
        initializeUiState()
    }

    private fun initializeUiState() {
        val listPlace=LocalPlaceProvider.getPlaceData()
        _uiState.value=
            CityUiState(
                placeList = listPlace,
                currentPlace = listPlace[0]
            )
    }


}