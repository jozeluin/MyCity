package com.cursokotlin.mycity.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import com.cursokotlin.mycity.data.LocalPlaceProvider
import com.cursokotlin.mycity.model.Category
import com.cursokotlin.mycity.model.Place

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecomemdationsListItem(
    place: Place,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray, //Card background color
            contentColor = Color.White),  //Card content color,e.g.text
        modifier=modifier.wrapContentSize(),
        border = BorderStroke(width = 2.dp, Color.Black),
        shape = RoundedCornerShape(20.dp),
        onClick = onItemClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .fillMaxWidth()

        )
        {
            Image(
                painter = painterResource(id = place.imageResoureId),
                contentDescription = "",
                modifier = modifier.height(100.dp)
            )
            Text(
                text = stringResource(id = place.titleResourceId),
                fontSize = 30.sp


            )
        }


    }


}
@Preview(showSystemUi = true)
@Composable
fun previewListItem(){
    ListRecomendationScren(
        place=LocalPlaceProvider.getPlaceData(),
        onClik = {},
        contentPadding=PaddingValues(0.dp)

    )
}
@Composable
fun ListRecomendationScren(
    place: List<Place>,
    onClik:(Place)->Unit,
    modifier: Modifier=Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)

) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier,
    ) {
        items(place,key={place ->place.id}) { currentplace->
            RecomemdationsListItem(
                place=currentplace,
                onItemClick= { onClik(currentplace) }
            )
        }
    }

}