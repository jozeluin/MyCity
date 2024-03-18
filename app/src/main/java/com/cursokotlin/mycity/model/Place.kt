package com.cursokotlin.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @DrawableRes val imageResoureId: Int,
    @StringRes val placeDetails: Int,
    val typePlace: TypePlace

)

enum class TypePlace(){
    Cafeteria,
    Biblioteca,
    Restaurante,
    SitioInteres,
    Cervecerias
}
