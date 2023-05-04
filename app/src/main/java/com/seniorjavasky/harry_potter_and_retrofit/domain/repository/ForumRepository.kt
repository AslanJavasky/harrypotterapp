package com.seniorjavasky.harry_potter_and_retrofit.domain.repository

import com.seniorjavasky.harry_potter_and_retrofit.domain.model.ForumItem

interface ForumRepository {

    fun sendMessage(text:String)
}