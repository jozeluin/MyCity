package com.cursokotlin.mycity.ui

import com.cursokotlin.mycity.data.LocalPlaceProvider
import com.cursokotlin.mycity.model.Category
import com.cursokotlin.mycity.model.Place

data class CityUiState(
    val placeList:List<Place> = emptyList(),
    val categoryList:List<Category> = emptyList(),
    val currentCategory: Category = LocalPlaceProvider.defaulCategory,
    val currentPlace:Place = LocalPlaceProvider.defaultPlace,
    val isShowingListRecomendations:Boolean= false



)
