package com.cursokotlin.mycity.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cursokotlin.mycity.data.LocalPlaceProvider
import com.cursokotlin.mycity.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CityViewModel:ViewModel() {

    private val _uiState= MutableStateFlow(CityUiState())
    val uiState:StateFlow<CityUiState> =_uiState


    init{
        initializeUiState()
    }

    private fun initializeUiState() {
        val listPlace=LocalPlaceProvider.getPlaceData()
        val listCategory=LocalPlaceProvider.getCategory()
        _uiState.value=
            CityUiState(
                placeList = listPlace,
                categoryList =listCategory,
                currentPlace = listPlace[0]
            )
    }

    fun updateCurrentCategory(category: Category) {
        _uiState.update {
            it.copy(currentCategory = category)

        }
        Log.i("viewmodel","update ${category.typePlaceScreen.name}")
    }


}