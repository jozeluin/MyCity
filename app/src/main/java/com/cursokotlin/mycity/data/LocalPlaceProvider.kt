package com.cursokotlin.mycity.data

import com.cursokotlin.mycity.R
import com.cursokotlin.mycity.model.Place
import com.cursokotlin.mycity.model.TypePlaceScreen

object LocalPlaceProvider {

    val defaultPlace= getPlaceData()[0]


    fun getPlaceData(): List<Place> {
        return listOf(
            Place(
                id = 1,
                titleResourceId = R.string.cafeteria_liquitos,
                imageResoureId = R.drawable.cafeteria_liquitos,
                placeDetails = R.string.Comentario_Cafeteria,
                typePlaceScreen = TypePlaceScreen.Cafeteria
            ),
            Place(
                id = 2,
                titleResourceId = R.string.cafeteria_la_crep,
                imageResoureId = R.drawable.cafeterias_la_crep,
                placeDetails = R.string.Comentario_Cafeteria,
                typePlaceScreen = TypePlaceScreen.Cafeteria
            ),
            Place(
                id = 3,
                titleResourceId = R.string.biblioteca_central,
                imageResoureId = R.drawable.biblioteca_central,
                placeDetails = R.string.Comentario_Bibliotecas,
                typePlaceScreen = TypePlaceScreen.Biblioteca
            ),
            Place(
                id = 4,
                titleResourceId = R.string.biblioteca_fondo,
                imageResoureId = R.drawable.biblioteca_fondo,
                placeDetails = R.string.Comentario_Bibliotecas,
                typePlaceScreen = TypePlaceScreen.Biblioteca
            ),
            Place(
                id = 5,
                titleResourceId = R.string.biblioteca_singuerlin,
                imageResoureId = R.drawable.biblioteca_singuerlin,
                placeDetails = R.string.Comentario_Bibliotecas,
                typePlaceScreen = TypePlaceScreen.Biblioteca
            ),
            Place(
                id = 6,
                titleResourceId = R.string.biblioteca_can_peixauet,
                imageResoureId = R.drawable.biblioteca_can_peixauet,
                placeDetails = R.string.Comentario_Bibliotecas,
                typePlaceScreen = TypePlaceScreen.Biblioteca
            ),
            Place(
                id = 7,
                titleResourceId = R.string.cerveceria_isalba,
                imageResoureId = R.drawable.cervecerias_isalba,
                placeDetails = R.string.Comentario_cerveceria,
                typePlaceScreen = TypePlaceScreen.Cerveceria
            ),
            Place(
                id = 8,
                titleResourceId = R.string.cerveceria_bar_castilla,
                imageResoureId = R.drawable.cerveceria_bar_castilla,
                placeDetails = R.string.Comentario_cerveceria,
                typePlaceScreen = TypePlaceScreen.Cerveceria
            ),
            Place(
                id = 9,
                titleResourceId = R.string.cerveceria_la_fabrica,
                imageResoureId = R.drawable.cerveceria_la_fabrica,
                placeDetails = R.string.Comentario_cerveceria,
                typePlaceScreen = TypePlaceScreen.Cerveceria
            ),
            Place(
                id = 10,
                titleResourceId = R.string.sitio_interes_ayuntamiento,
                imageResoureId = R.drawable.interes_ayuntamiento,
                placeDetails = R.string.Comentario_sitios_interes,
                typePlaceScreen = TypePlaceScreen.SitioInteres
            ),
            Place(
                id = 11,
                titleResourceId = R.string.sitio_interes_parque_rio,
                imageResoureId = R.drawable.parque_rio,
                placeDetails = R.string.Comentario_sitios_interes,
                typePlaceScreen = TypePlaceScreen.SitioInteres
            ),
            Place(
                id = 12,
                titleResourceId = R.string.sitio_interes_parque_rio_atardecer,
                imageResoureId = R.drawable.parque_rio_tardecer,
                placeDetails = R.string.Comentario_sitios_interes,
                typePlaceScreen = TypePlaceScreen.SitioInteres
            ),
            Place(
                id = 13,
                titleResourceId = R.string.sitio_interes_puig_Castellar,
                imageResoureId = R.drawable.puig_castellar,
                placeDetails = R.string.Comentario_sitios_interes,
                typePlaceScreen = TypePlaceScreen.SitioInteres
            ),
            Place(
                id = 14,
                titleResourceId = R.string.sitio_interes_puente_noche,
                imageResoureId = R.drawable.santa_coloma_de_gramanet_puente_noche,
                placeDetails = R.string.Comentario_sitios_interes,
                typePlaceScreen = TypePlaceScreen.SitioInteres
            ),
            Place(
                id = 15,
                titleResourceId = R.string.restaurante_don_Martin,
                imageResoureId = R.drawable.rest_don_martin,
                placeDetails = R.string.Comentario_Restaurantes,
                typePlaceScreen = TypePlaceScreen.Restaurante
            ),
            Place(
                id = 16,
                titleResourceId = R.string.restaurante_l_obra,
                imageResoureId = R.drawable.rest_l_obra,
                placeDetails = R.string.Comentario_Restaurantes,
                typePlaceScreen = TypePlaceScreen.Restaurante
            ),
            Place(
                id = 17,
                titleResourceId = R.string.restaurante_santa_lola,
                imageResoureId = R.drawable.rest_santa_lola,
                placeDetails = R.string.Comentario_Restaurantes,
                typePlaceScreen = TypePlaceScreen.Restaurante
            )

            )
    }
}