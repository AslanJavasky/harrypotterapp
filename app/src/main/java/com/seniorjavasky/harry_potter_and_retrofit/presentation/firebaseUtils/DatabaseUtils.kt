package com.seniorjavasky.harry_potter_and_retrofit.presentation.firebaseUtils

import android.widget.TextView
import android.widget.Toast
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ForumItem
import com.seniorjavasky.harry_potter_and_retrofit.presentation.MainActivity


class DatabaseUtils(
    private val mainActivity: MainActivity
) {

    private val dbFirebase = Firebase.database
    private val forumRefence = dbFirebase.getReference(FORUM_CHILD)

    fun sendTextToDb(text: String) {
        forumRefence.push().setValue(
            ForumItem(
                text = text,
                user = mainActivity.authUtils.getUserName()
            )
        )
        Toast.makeText(mainActivity, "Text is sended!", Toast.LENGTH_LONG).show()
    }

    fun retreiveDataFromDb(textView: TextView) {
//        forumRefence.addListenerForSingleValueEvent(
//            object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//
//                    val array = mutableListOf<String>()
//
//                    snapshot.children.forEach {
//                        it.getValue(String::class.java)?.let { item ->
//                            array.add(item)
//                        }
//                    }
//
//
//                    textView.text = array.toString()
//                }
//
//                override fun onCancelled(error: DatabaseError) {}
//
//            })
    }

    fun getFirebaseRecyclerOptions() =
        FirebaseRecyclerOptions.Builder<ForumItem>()
            .setQuery(forumRefence, ForumItem::class.java)
            .build()


    companion object {

        private const val FORUM_CHILD = "Forum"
    }
}


