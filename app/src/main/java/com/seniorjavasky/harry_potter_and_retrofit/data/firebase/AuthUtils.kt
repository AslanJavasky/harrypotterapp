package com.seniorjavasky.harry_potter_and_retrofit.data.firebase

import android.content.Intent
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.activities.MainActivity
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.activities.SignInActivity
import javax.inject.Inject

class AuthUtils(

    internal val auth: FirebaseAuth,
    internal val authUI: AuthUI
) {


    fun getUserName(): String? {
        val user = auth.currentUser
        return if (user != null) {
            user.displayName
        } else ANONYMOUS
    }

    companion object {
        fun getIntentForSignIN() =
            AuthUI.getInstance().createSignInIntentBuilder()
                .setLogo(R.drawable.harry_potter_30)
                .setAvailableProviders(
                    listOf(
                        AuthUI.IdpConfig.GoogleBuilder().build(),
                        AuthUI.IdpConfig.EmailBuilder().build(),
                        AuthUI.IdpConfig.PhoneBuilder().build()
                    )
                )
                .build()


        private const val ANONYMOUS = "Anonymous"
    }
}