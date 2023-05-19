package com.seniorjavasky.harry_potter_and_retrofit.data

import android.app.Application
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.data.firebase.FirebaseUtils
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.ForumItem
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.ForumRepository

class ForumRepositoryImpl(
    application: Application,
    private val firebaseInstance: FirebaseUtils
) : ForumRepository {



    override fun sendMessage(text: String) {
        val currentUser = firebaseInstance.authUtils.getUserName()
        val message = ForumItem(text, currentUser)

        firebaseInstance.forumRefence.push().setValue(message)
    }
}