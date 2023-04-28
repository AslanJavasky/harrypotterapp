package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.presentation.firebaseUtils.DatabaseUtils

class ForumViewModel : ViewModel() {

    fun sendTextToFirebaseDb(text: String, databaseUtils: DatabaseUtils) {
        databaseUtils.sendTextToDb(text)
    }

    fun retreiveDataFromDb(textView: TextView, databaseUtils: DatabaseUtils) {
        databaseUtils.retreiveDataFromDb(textView)
    }

    inner class TextWatcherForEditText(
        private val imageButton: ImageButton
    ) : TextWatcher {

        override fun onTextChanged(
            text: CharSequence?, start: Int, before: Int, count: Int
        ) {
            if (text?.trim()!!.isNotEmpty()) {
                imageButton.isEnabled = true
                imageButton.setImageResource(R.drawable.send_blue)
            } else {
                imageButton.isEnabled = false
                imageButton.setImageResource(R.drawable.send_gray)
            }

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun afterTextChanged(s: Editable?) {}
    }

}

data class ForumItem(
    val text: String?="",
    val user: String?=""
)
