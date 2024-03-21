package com.cursokotlin.mycity.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.cursokotlin.mycity.model.Category
import com.cursokotlin.mycity.model.Place
import com.cursokotlin.mycity.model.TypePlaceScreen

@Composable
fun ListCategoryScreen(
    category: List<Category>,
    onClik:(Category)->Unit,
    modifier: Modifier,
    contentPadding:PaddingValues= PaddingValues(0.dp)

) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier,
    ) {
      items(category,key={categoria ->categoria.id}) { currentcategoria->
          CategoryItem(
              category =currentcategoria,
              onItemClick ={onClik(currentcategoria)}
          )
      }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryItem(
    category: Category,
    onItemClick:(Category)-> Unit,
    modifier: Modifier=Modifier

)
{
    Card(
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray, //Card background color
            contentColor = Color.White),  //Card content color,e.g.text
        modifier=modifier.wrapContentSize(),
        border = BorderStroke(width = 2.dp, Color.Black),
        shape = RoundedCornerShape(20.dp),
        onClick = {onItemClick(category)}
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .fillMaxWidth()

        )
        {

            Box(){
                Image(
                    painter = painterResource(id = category.imageResoureId),
                    contentDescription = "",
                    modifier = modifier.height(100.dp)
                )
            }

            Text(
                text = stringResource(id =category.typePlaceScreen.title),
                fontSize = 30.sp


            )
        }


    }



}

@Composable
@Preview(showSystemUi = true)
fun ListCategoryScreenPreview(){
    ListCategoryScreen(
        category = LocalPlaceProvider.getCategory(),
        onClik ={} ,
        modifier = Modifier)

}



/**
 * Es el item de la lista de categorias
 *
 * @param place
 * @param onItemClick
 * @param modifier
 */



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
