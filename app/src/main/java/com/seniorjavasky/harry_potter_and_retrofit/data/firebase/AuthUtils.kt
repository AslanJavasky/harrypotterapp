package com.seniorjavasky.harry_potter_and_retrofit.data.firebase

import android.app.Application
import android.content.Intent
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.presentation.MainActivity
import com.seniorjavasky.harry_potter_and_retrofit.presentation.SignInActivity

class AuthUtils(
    private val mainActivity: MainActivity
) {

    private val auth = Firebase.auth
    private val authUI=AuthUI.getInstance()

    private fun isDoneAuth(): Boolean = auth.currentUser != null
    private val signInActivityClass=SignInActivity::class.java



    fun signUpIn() {
        if (!isDoneAuth()) {
            val intent = Intent(mainActivity, signInActivityClass)
            mainActivity.startActivity(intent)
            mainActivity.finish()
        }
    }

    fun signOut(){
        authUI.signOut(mainActivity)
    }

    fun getUserName(): String? {
        val user = auth.currentUser
        return if (user != null) {
            user.displayName
        } else ANONYMOUS
    }

    companion object{
        fun getIntentForSignIN()=
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


        private const val ANONYMOUS="Anonymous"
    }
}