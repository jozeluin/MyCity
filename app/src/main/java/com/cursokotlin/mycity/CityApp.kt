package com.cursokotlin.mycity

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cursokotlin.mycity.model.Screens
import com.cursokotlin.mycity.model.TypePlaceScreen
import com.cursokotlin.mycity.ui.CityViewModel
import com.cursokotlin.mycity.ui.ListCategoryScreen
import com.cursokotlin.mycity.ui.utils.CityContentType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val curresntScreen = TypePlaceScreen.valueOf(
        backStackEntry?.destination?.route ?: TypePlaceScreen.Cafeteria.name
    )

    val viewModel: CityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val contentType: CityContentType


    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            contentType = CityContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Medium -> {
            contentType = CityContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Expanded -> {
            contentType = CityContentType.LIST_AND_DETAIL
        }

        else -> {
            contentType = CityContentType.LIST_ONLY
        }

    }


    Scaffold(
        topBar = {
            CityAppBar(
                typePlaceScreen = curresntScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateup = { navController.navigateUp() })

        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = TypePlaceScreen.Cafeteria.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            if (contentType != CityContentType.LIST_AND_DETAIL) {
                Log.i("MiCategoria", "He pasado")
                composable(route = TypePlaceScreen.Cafeteria.name) {
                    ListCategoryScreen(
                        category = uiState.categoryList,
                        onClik = {},
                        modifier = Modifier
                    )

                }
                composable(route = Screens.LISTA_RECOMENDACIONES.name) {

                }
                composable(route = Screens.DETALLES.name) {

                }

            } else {

            }

        }
    }

    /* composable(route = LunchTrayScreen.Start.name) {
         StartOrderScreen(
             onStartOrderButtonClicked = {
                 navController.navigate(LunchTrayScreen.Entree.name)
             },
             modifier = Modifier
                 .fillMaxSize()
                 .padding(innerPadding)
         )
     }*/


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppBar(
    typePlaceScreen: TypePlaceScreen,
    canNavigateBack: Boolean,
    navigateup: () -> Unit,
    modifier: Modifier = Modifier

) {
    TopAppBar(

        title = { Text(stringResource(typePlaceScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateup) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = ""
                    )

                }
            }

        }
    )

}

@Preview()
@Composable
fun cityAppbarpreview() {
    val tipodecategoria = TypePlaceScreen.Cafeteria
    CityAppBar(
        typePlaceScreen = tipodecategoria,
        canNavigateBack = true,
        navigateup = { })

}

@Preview()
@Composable
fun citypreview() {
    val navController: NavHostController = rememberNavController()

    CityApp(windowSize = WindowWidthSizeClass.Compact, navController = navController)
}






















