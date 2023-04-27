package com.seniorjavasky.harry_potter_and_retrofit.presentation.firebaseUtils

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

    private val signInActivity=SignInActivity()

    private val auth = Firebase.auth
    private val authUI=AuthUI.getInstance()

    private fun isDoneAuth(): Boolean = auth.currentUser != null

    fun signUpIn() {
        if (!isDoneAuth()) {
            val intent = Intent(mainActivity, SignInActivity::class.java)
            mainActivity.startActivity(intent)
            mainActivity.finish()
        }
    }

    fun signOut(){
        authUI.signOut(mainActivity)
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
    }

}