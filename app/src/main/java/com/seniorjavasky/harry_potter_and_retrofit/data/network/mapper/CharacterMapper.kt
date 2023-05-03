package com.seniorjavasky.harry_potter_and_retrofit.data.network.mapper

import com.seniorjavasky.harry_potter_and_retrofit.data.network.dto.CharacterDto
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterItem


class CharacterMapper {
    fun mapDtoToModel(characterDto: CharacterDto) = CharacterItem(
        id = characterDto.id,
        name = characterDto.name,
        hogwartsHouse = characterDto.hogwartsHouse,
        imageUrl = characterDto.imageUrl
    )

    fun mapListDtoToListModel(dtoList: List<CharacterDto>) = dtoList.map {
        mapDtoToModel(it)
    }
}