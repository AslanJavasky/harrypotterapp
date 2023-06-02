package com.seniorjavasky.harry_potter_and_retrofit.lessons.compose.containers_2

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ColumnScreen() {
  MyColumn()

}

@Composable
fun MyColumn() {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize()
  ) {

    THREE_ELEMENT_LIST.forEach {
      Text(
        text = it,
        fontSize = 22.sp
      )
    }
  }
}