package com.cursokotlin.mycity.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cursokotlin.mycity.data.LocalPlaceProvider
import com.cursokotlin.mycity.model.Category
import com.cursokotlin.mycity.model.Place
import com.cursokotlin.mycity.model.TypePlaceScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CityUiState())
    val uiState: StateFlow<CityUiState> = _uiState

    var listOfItemsbycategory:List<Place> = emptyList()


    init {
        initializeUiState()
    }

    private fun initializeUiState() {
        val listPlace = LocalPlaceProvider.getPlaceData()
        val listCategory = LocalPlaceProvider.getCategory()
        _uiState.value =
            CityUiState(
                placeList = listPlace,
                categoryList = listCategory,
                currentPlace = listPlace[0]
            )

        listOfItemsbycategory = selectedItemsbyCategory(TypePlaceScreen.Cafeteria)
    }

    fun updateCurrentCategory(category: Category) {

        _uiState.update {
            it.copy(currentCategory = category)
        }

        listOfItemsbycategory =  selectedItemsbyCategory(category.typePlaceScreen)


        Log.i("viewmodel", "update ${category.typePlaceScreen.name}")
    }

    fun selectedItemsbyCategory(typePlaceScreen: TypePlaceScreen): List<Place> {

        val listofItems=uiState.value.placeList.filter{x ->x.typePlaceScreen==typePlaceScreen}

        return listofItems
    }

    fun updateCurrentPlace(place: Place) {
        _uiState.update{
            it.copy(currentPlace = place)
        }

    }


}

