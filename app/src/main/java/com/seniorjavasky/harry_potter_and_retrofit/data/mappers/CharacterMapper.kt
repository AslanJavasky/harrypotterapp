package com.seniorjavasky.harry_potter_and_retrofit.data.mappers

import com.seniorjavasky.harry_potter_and_retrofit.data.local.entity.CharacterDbModel
import com.seniorjavasky.harry_potter_and_retrofit.data.network.dto.CharacterDto
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterItem
import javax.inject.Inject


class CharacterMapper @Inject constructor() {
    fun mapDtoToModel(characterDto: CharacterDto) = CharacterItem(
        id = characterDto.id,
        name = characterDto.name,
        hogwartsHouse = characterDto.hogwartsHouse,
        imageUrl = characterDto.imageUrl
    )

    fun mapListDtoToListModel(dtoList: List<CharacterDto>) = dtoList.map {
        mapDtoToModel(it)
    }

    fun mapModelToDbModel(characterItem: CharacterItem) = CharacterDbModel(
        id = characterItem.id,
        name = characterItem.name,
        hogwartsHouse = characterItem.hogwartsHouse,
        imageUrl = characterItem.imageUrl
    )

    fun mapModelListToDbModelList(charactersList: List<CharacterItem>) = charactersList.map {
        mapModelToDbModel(it)
    }

    fun mapDbModelToModel(characterDb: CharacterDbModel) = CharacterItem(
        id = characterDb.id,
        name = characterDb.name,
        hogwartsHouse = characterDb.hogwartsHouse,
        imageUrl = characterDb.imageUrl
    )

    fun mapDbModelListToModelList(charactersDbModel: List<CharacterDbModel>) = charactersDbModel.map {
        mapDbModelToModel(it)
    }
}