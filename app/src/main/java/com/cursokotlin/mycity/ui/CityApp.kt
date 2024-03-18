package com.cursokotlin.mycity.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cursokotlin.mycity.ui.utils.CityContentType


@Composable
fun CityApp (
    windowSize: WindowWidthSizeClass,
    navController:NavHostController= rememberNavController(),
    modifier: Modifier=Modifier
){
    val viewModel:CityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val contentType:CityContentType


    when(windowSize){
        WindowWidthSizeClass.Compact->{
            contentType=CityContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium->{
            contentType=CityContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded->{
            contentType=CityContentType.LIST_AND_DETAIL
        }
        else->{
            contentType=CityContentType.LIST_ONLY
        }




    }




}