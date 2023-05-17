package com.seniorjavasky.harry_potter_and_retrofit.domain.repository

import androidx.paging.Pager
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterPagingItem


interface CharacterPagingRepository {
    fun getPager(): Pager<Int, CharacterPagingItem>
}