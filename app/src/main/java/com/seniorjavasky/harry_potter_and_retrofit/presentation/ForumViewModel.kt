package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.seniorjavasky.harry_potter_and_retrofit.presentation.firebaseUtils.DatabaseUtils

class ForumViewModel : ViewModel() {



    fun sendTextToFirebaseDb(text: String, databaseUtils: DatabaseUtils) {
        databaseUtils.sendTextToDb(text)


    }

    fun retreiveDataFromDb(textView: TextView,databaseUtils: DatabaseUtils) {
        databaseUtils.retreiveDataFromDb(textView)
    }

}