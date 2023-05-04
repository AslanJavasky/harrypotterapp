package com.seniorjavasky.harry_potter_and_retrofit.data.firebase

import android.app.Application
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.ForumItem
import com.seniorjavasky.harry_potter_and_retrofit.presentation.MainActivity

class FirebaseUtils {

    lateinit var authUtils : AuthUtils

    private val dbFirebase = Firebase.database
    val forumRefence = dbFirebase.getReference(FORUM_CHILD)

    val crashlytics = Firebase.crashlytics

    fun getFirebaseRecyclerOptions() =
        FirebaseRecyclerOptions.Builder<ForumItem>()
            .setQuery(forumRefence, ForumItem::class.java)
            .build()


    fun initAuthUtils(mainActivity: MainActivity){
        authUtils=AuthUtils(mainActivity)
    }

    companion object {

        private const val FORUM_CHILD = "Forum"
        private var INSTANCE: FirebaseUtils? = null
        private val LOCK = Any()

        fun getInstance(application: Application): FirebaseUtils {
            INSTANCE?.let { firebaseInstance ->
                return firebaseInstance
            }

            synchronized(LOCK) {
                INSTANCE?.let { firebaseInstance ->
                    return firebaseInstance
                }

                INSTANCE = FirebaseUtils()
                return FirebaseUtils()
            }
        }


    }
}