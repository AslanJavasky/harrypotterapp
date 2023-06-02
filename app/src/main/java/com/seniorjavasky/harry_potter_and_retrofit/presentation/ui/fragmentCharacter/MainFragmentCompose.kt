package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacter

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
//import coil.compose.SubcomposeAsyncImage
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterItem
import com.seniorjavasky.harry_potter_and_retrofit.R

@Composable
fun MainFragmentCompose(viewModel:MainViewModel) {

    val character by viewModel.character.collectAsState()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painterResource(R.drawable.hogwarts_background),
            contentDescription ="background image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        MainColumn(character, viewModel)
    }


}

@Composable
private fun MainColumn(
    character: CharacterItem,
    viewModel: MainViewModel
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        SubcomposeAsyncImage(
            model = character.imageUrl,
            contentDescription = "image of character",
            loading = {
                CircularProgressIndicator(color = Color.Blue, strokeWidth = 8.dp )
            },
            modifier = Modifier
                .size(200.dp, 250.dp)
                .border(3.dp, color = Color.Blue),
            contentScale = ContentScale.FillBounds

        )
        Text(character.name, color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Text(character.hogwartsHouse,color = Color.White, fontSize = 20.sp)
        OutlinedButton(onClick = { viewModel.randomCharacter() }) {
            Text(text = stringResource(R.string.btn_text), color = Color.LightGray, fontSize = 25.sp)
        }
    }
}

