package com.seniorjavasky.harry_potter_and_retrofit.presentation.firebaseUtils

import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.seniorjavasky.harry_potter_and_retrofit.presentation.MainActivity
import org.json.JSONObject

class DatabaseUtils(
    private val mainActivity: MainActivity
) {

    private val dbFirebase = Firebase.database
    private val forumRefence = dbFirebase.getReference(FORUM_CHILD)

    fun sendTextToDb(text: String) {
        forumRefence.push().setValue(text)
        Toast.makeText(mainActivity, "Text is sended!", Toast.LENGTH_LONG).show()
    }

    fun retreiveDataFromDb(textView: TextView) {
        forumRefence.addListenerForSingleValueEvent(
            object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val array = mutableListOf<String>()

                snapshot.children.forEach {
                   it.getValue(String::class.java)?.let { item ->
                       array.add(item)
                   }
                }


                textView.text = array.toString()
            }

            override fun onCancelled(error: DatabaseError) {}

        })
    }

    companion object {

        private const val FORUM_CHILD = "Forum"
    }
}


