package com.seniorjavasky.harry_potter_and_retrofit.lessons.compose.containers_2

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.seniorjavasky.harry_potter_and_retrofit.R

@Composable
fun GridScreen() {

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(3),
        content = {
            items(array.size){
                GridIcon(array[it])
            }
        }
    )
}


@Composable
fun GridIcon(iconResource:ImageVector){
    Icon(
        imageVector = iconResource,
        contentDescription = "null",
        modifier = Modifier
            .size(80.dp)
            .padding(20.dp),
        tint = colorResource(R.color.teal_700)
    )
}

private val array = listOf(
    Icons.Filled.Check,
    Icons.Filled.Close,
    Icons.Filled.ThumbUp,
    Icons.Filled.Build,
    Icons.Filled.Delete,
    Icons.Filled.Home,
    Icons.Filled.Close,
    Icons.Filled.ThumbUp,
    Icons.Filled.Build,
    Icons.Filled.ThumbUp
)