package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacterList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterItem
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterPagingItem
import java.util.*

@Composable
fun CharacterItemCompose(
    character: CharacterItem?=null,
    characterPagingItem: CharacterPagingItem?=null
    ) {

    if (character != null){
        CharacterCard(character)
    }else{
        val characterMapped=CharacterItem(
            id= Random().nextInt(),
            name = characterPagingItem?.name ?: "N/D",
            hogwartsHouse = characterPagingItem?.hogwartsHouse ?: "N/D",
            imageUrl = characterPagingItem?.imageUrl ?: ""
        )
        CharacterCard(characterMapped)
    }
}

@Composable
private fun CharacterCard(character: CharacterItem?) {
    Card(
        elevation = CardDefaults.cardElevation(16.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.background_card)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(4.dp))
            SubcomposeAsyncImage(
                model = if (character!!.imageUrl != "") character!!.imageUrl else R.drawable.empty_face,
                contentDescription = "character image",
                loading = { CircularProgressIndicator() },
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(100)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(32.dp))
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(character.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                Text(character.hogwartsHouse, fontSize = 15.sp)
            }
        }
    }
}






