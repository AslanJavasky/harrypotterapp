package com.seniorjavasky.harry_potter_and_retrofit.data.firebase

import android.app.Application
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.ForumItem
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.activities.MainActivity

class FirebaseUtils(
    private val dbFirebase: FirebaseDatabase,
    internal val crashlytics: FirebaseCrashlytics,
    internal val authUtils: AuthUtils
) {

    val forumRefence = dbFirebase.getReference(FORUM_CHILD)


    fun getFirebaseRecyclerOptions() =
        FirebaseRecyclerOptions.Builder<ForumItem>()
            .setQuery(forumRefence, ForumItem::class.java)
            .build()


    companion object {

        private const val FORUM_CHILD = "Forum"
        private var INSTANCE: FirebaseUtils? = null
        private val LOCK = Any()


        fun getInstance(
            application: Application,
            firebaseUtils: FirebaseUtils
        ): FirebaseUtils {
            INSTANCE?.let { firebaseInstance ->
                return firebaseInstance
            }

            synchronized(LOCK) {
                INSTANCE?.let { firebaseInstance ->
                    return firebaseInstance
                }

                INSTANCE = FirebaseUtils(
                    firebaseUtils.dbFirebase,
                    firebaseUtils.crashlytics,
                    firebaseUtils.authUtils
                )
                return FirebaseUtils(
                    firebaseUtils.dbFirebase,
                    firebaseUtils.crashlytics,
                    firebaseUtils.authUtils
                )
            }
        }


    }
}