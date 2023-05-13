package com.seniorjavasky.harry_potter_and_retrofit.data.paging.mapper


import com.seniorjavasky.harry_potter_and_retrofit.data.paging.dto.DataJson
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterPagingItem

class CharacterPagingMapper {

    fun mapDtoPagingToItemPaging(dtoList: List<DataJson>) =
        dtoList.map {
            CharacterPagingItem(
                it.id,
                it.attributes.name,
                it.attributes.bloodStatus,
                it.attributes.hogwartsHouse,
                it.attributes.patronus,
                it.attributes.imageUrl
            )
        }
}