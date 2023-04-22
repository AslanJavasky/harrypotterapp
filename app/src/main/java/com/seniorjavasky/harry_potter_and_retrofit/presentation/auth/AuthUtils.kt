package com.seniorjavasky.harry_potter_and_retrofit.presentation.auth

import android.widget.Toast
import androidx.annotation.StringRes
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.presentation.MainActivity


@Suppress("NAME_SHADOWING")
class AuthUtils(
    private val context: MainActivity
) {

    fun signUpWithEmail(email: String, password: String) {
        val user =
            context.auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        task.result.user?.sendEmailVerification()
                            ?.addOnCompleteListener { task ->
                            if (task.isSuccessful){
                                showToast(R.string.msg_verification_success)
                            }else{
                                showToast(R.string.msg_verification_failed)
                            }
                        }
                    } else {
                        showToast(R.string.msg_user_creation_failed)
                    }
                }
    }



    fun signInWithEmail(email: String, password: String) {
        val user =
            context.auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        showToast(R.string.msg_sign_in)
                    }else{
                        showToast(R.string.msg_sign_in_error)
                    }
                }
    }

    fun signOut() {
        context.auth.signOut()
        showToast(R.string.msg_sign_out)
    }

    private fun showToast(@StringRes str:Int) {
        Toast.makeText(
            context,
            context.resources.getString(str),
            Toast.LENGTH_LONG
        ).show()
    }
}