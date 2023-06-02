package com.seniorjavasky.harry_potter_and_retrofit.lessons.compose.containers_2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

val THREE_ELEMENT_LIST = listOf("first","second", "third")

@Composable
fun RowScreen() {
  MyRow()

}

@Composable
fun MyRow() {
  Row(verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceEvenly,
    modifier = Modifier.fillMaxSize()) {

    THREE_ELEMENT_LIST.forEach {
      Text(
        text = it,
        fontSize = 18.sp
      )
    }
  }
}