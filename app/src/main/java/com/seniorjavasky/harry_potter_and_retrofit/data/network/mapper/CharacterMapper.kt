package com.seniorjavasky.harry_potter_and_retrofit.data.network.mapper

import com.seniorjavasky.harry_potter_and_retrofit.data.network.dto.CharacterDto
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterModel


class CharacterMapper {
    fun mapDtoToModel(characterDto: CharacterDto) = CharacterModel(
        id = characterDto.id,
        name = characterDto.name,
        hogwartsHouse = characterDto.hogwartsHouse,
        imageUrl = characterDto.imageUrl
    )

    fun mapListDtoToListModel(dtoList: List<CharacterDto>): List<CharacterModel> {
        var resList = mutableListOf<CharacterModel>()
        dtoList.forEach { resList.add(mapDtoToModel(it)) }
        return resList
    }

}