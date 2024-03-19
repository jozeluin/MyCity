package com.cursokotlin.mycity.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cursokotlin.mycity.R
import com.cursokotlin.mycity.data.LocalPlaceProvider
import com.cursokotlin.mycity.model.Place
import com.cursokotlin.mycity.model.TypePlaceScreen

@Composable
fun ListCategoryScreen(
    places: List<Place>,
    modifier: Modifier

) {


}

/**
 * Es el item de la lista de categorias
 *
 * @param place
 * @param onItemClick
 * @param modifier
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceListItem(
    place: Place,
    onItemClick: (Place) -> Unit,
    modifier: Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray, //Card background color
            contentColor = Color.White),  //Card content color,e.g.text
        modifier=modifier.wrapContentSize(),
        border = BorderStroke(width = 2.dp, Color.Black),
        shape = RoundedCornerShape(20.dp),
        onClick = { onItemClick(place) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .fillMaxWidth()

        )
        {
            Image(
                painter = painterResource(id = TypeItem(place = place).first),
                contentDescription = "",
                modifier = modifier.height(100.dp)
            )
            Text(
                text = stringResource(id = TypeItem(place = place).second),
                fontSize = 30.sp


                )
        }


    }


}

@Preview(showSystemUi = true)
@Composable
fun PlaceListItemPreview() {
    PlaceListItem(place = LocalPlaceProvider.defaultPlace, onItemClick = {}, modifier = Modifier)

}

/**
 * Dado un lugar, revisa que tipo es y devuelve la imagen que
 * corresponde y el titulo, para la pantalla de lista de  las categorias
 *
 * @param place
 * @return
 */
@Composable
fun TypeItem(place: Place): Pair<Int, Int> {
    // val miPair = Pair(primero = "Carlos", segundo = 34)
    var imagen: Int = 0
    var titulo: Int = 0

    when (place.typePlaceScreen) {
        TypePlaceScreen.Cafeteria -> {
            imagen = R.drawable.cafeteria
            titulo = R.string.cafeterias

        }

        TypePlaceScreen.Biblioteca -> {
            imagen = R.drawable.biblioteca
            titulo = R.string.bibliotecas
        }

        TypePlaceScreen.Restaurante -> {
            imagen = R.drawable.restaurante
            titulo = R.string.restaurantes
        }

        TypePlaceScreen.SitioInteres -> {
            imagen = R.drawable.punto_de_interes
            titulo = R.string.sitios_de_interes
        }

        TypePlaceScreen.Cerveceria -> {
            imagen = R.drawable.cerveza
            titulo = R.string.cervecerias
        }

        else -> {}
    }
    var mipar = Pair(imagen, titulo)
    return mipar

}
