package com.cursokotlin.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.cursokotlin.mycity.R

data class Place(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @DrawableRes val imageResoureId: Int,
    @StringRes val placeDetails: Int,
    val typePlaceScreen: TypePlaceScreen

)
data class Category(
    val id: Int,
    val typePlaceScreen: TypePlaceScreen,
    @DrawableRes val imageResoureId: Int
)

enum class TypePlaceScreen(@StringRes val title:Int){
    Cafeteria(title = R.string.cafeterias),
    Biblioteca(title = R.string.bibliotecas),
    Restaurante(title = R.string.restaurantes),
    SitioInteres(title = R.string.sitios_de_interes),
    Cerveceria(title = R.string.cervecerias)
}

enum class Screens(){
    LISTA_CATEGORIAS,LISTA_RECOMENDACIONES,DETALLES
}
