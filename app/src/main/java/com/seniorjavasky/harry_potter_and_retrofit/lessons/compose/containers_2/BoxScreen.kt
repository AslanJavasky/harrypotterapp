package com.seniorjavasky.harry_potter_and_retrofit.lessons.compose.containers_2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp


@Composable
fun BoxScreen() {
  MyBox()

}

@Composable
fun MyBox(
  modifier: Modifier = Modifier,
  contentModifier: Modifier = Modifier
) {
  Box(modifier = modifier.fillMaxSize()) {
    Text(
      text = THREE_ELEMENT_LIST[0],
      fontSize = 22.sp,
      modifier = contentModifier.align(Alignment.TopStart)
    )

    Text(
      text = THREE_ELEMENT_LIST[1],
      fontSize = 22.sp,
      modifier = contentModifier.align(Alignment.Center)
    )

    Text(
      text = THREE_ELEMENT_LIST[2],
      fontSize = 22.sp,
      modifier = contentModifier.align(Alignment.BottomEnd)
    )
  }
}