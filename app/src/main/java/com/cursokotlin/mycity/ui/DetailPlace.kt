package com.cursokotlin.mycity.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cursokotlin.mycity.CityAppBar
import com.cursokotlin.mycity.model.Place
import com.cursokotlin.mycity.model.Screens
import com.cursokotlin.mycity.ui.theme.MyCityTheme


/*
private fun SportsListImageItem(sport: Sport, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(sport.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}*/

@Composable
 fun DetailPlace(
    selectedPlace: Place, modifier: Modifier, contentPadding: PaddingValues
) {
    val scrollState = rememberScrollState()
    val layoutDirection = LocalLayoutDirection.current
    Box(
        modifier = modifier
            .verticalScroll(state = scrollState)
            .padding(top = contentPadding.calculateTopPadding())
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(
                bottom = contentPadding.calculateTopPadding(),
                start = contentPadding.calculateStartPadding(layoutDirection),
                end = contentPadding.calculateEndPadding(layoutDirection)
            )
        ) {
            Text(
                text = stringResource(id = selectedPlace.titleResourceId),
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
            Spacer(modifier = modifier.size(30.dp))

            Box {

                Box(
                    contentAlignment = Alignment.TopCenter,
                        modifier = modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .paint( painterResource(id = selectedPlace.imageResoureId),
                                contentScale = ContentScale.FillBounds)

                )


                {
                    /*Image(
                        painter = painterResource(selectedPlace.imageResoureId),
                        contentDescription = null,
                        alignment = Alignment.Center,
                        contentScale = ContentScale.FillBounds,
                    )
*/

                }


            }
            Spacer(modifier = modifier.size(30.dp))
            Text(
                text = stringResource(selectedPlace.placeDetails),
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle= FontStyle.Italic,
                modifier = Modifier.padding(
                    vertical = 20.dp,
                    horizontal = 20.dp
                )
            )



        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DetailPlacePreview() {
    val viewModel: CityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val tipodecategoria = Screens.LISTA_CATEGORIAS
    CityAppBar(
        screens = tipodecategoria,
        canNavigateBack = true,
        navigateup = { })

    Scaffold(
        topBar = {
            CityAppBar(
                screens = tipodecategoria,
                canNavigateBack = true,
                navigateup = { })

        }) { innerPadding ->

        MyCityTheme {
            Surface {
                DetailPlace(
                    selectedPlace = uiState.currentPlace,
                    modifier = Modifier,
                    contentPadding = innerPadding,

                    )
            }
        }
    }

}


