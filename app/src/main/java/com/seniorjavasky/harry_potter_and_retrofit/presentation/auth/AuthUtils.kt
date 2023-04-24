package com.seniorjavasky.harry_potter_and_retrofit.presentation.auth

import android.widget.Toast
import androidx.annotation.StringRes
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.GoogleAuthProvider
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.presentation.MainActivity


@Suppress("NAME_SHADOWING")
class AuthUtils(
    private val context: MainActivity
) {

    val googleClient: GoogleSignInClient
        get() = GoogleSignIn.getClient(
            context,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.resources.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        )


    fun signUpWithEmail(email: String, password: String) {
        val user =
            context.auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        task.result.user?.sendEmailVerification()
                            ?.addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    showToast(R.string.msg_verification_success)
                                } else {
                                    showErrorToast(task.exception?.localizedMessage)
                                }
                            }
                    } else {

                        if (task.exception is FirebaseAuthUserCollisionException) {
                            val credential =
                                EmailAuthProvider.getCredential(email, password)
                            context.auth.currentUser?.linkWithCredential(credential)
                            showToast(R.string.msg_link_account)
                        } else {
                            showErrorToast(task.exception?.localizedMessage)
                        }


                    }
                }
    }


    fun signInWithEmail(email: String, password: String) {
        val user =
            context.auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        showToast(R.string.msg_sign_in)
                    } else {
                        showErrorToast(task.exception?.localizedMessage)
                    }
                }
    }

    fun signOut() {
        context.auth.signOut()
        googleClient.signOut()
        showToast(R.string.msg_sign_out)
    }

    fun resetPasswordForEmail(email: String) {
        context.auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    showToast(R.string.msg_reset_password)
                } else {
                    showErrorToast(task.exception?.localizedMessage)
                }
            }

    }

    fun btnGoogleClickListener() {
        val intent = googleClient.signInIntent
        context.startActivityForResult(intent, REQUEST_CODE_FOR_SIGN_IN)
    }

    fun signInWithGoogle(idToken: String?) {
        idToken?.let {
            val credential =
                GoogleAuthProvider.getCredential(idToken, null)
            context.auth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        showToast(R.string.msg_sign_in)
                    } else {
                        showErrorToast(task.exception?.localizedMessage)
                    }
                }
        }
    }

    private fun showToast(@StringRes str: Int) {
        Toast.makeText(
            context,
            context.resources.getString(str),
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showErrorToast(strMsg: String?) {
        strMsg?.let {
            Toast.makeText(
                context,
                it,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    companion object {
        const val REQUEST_CODE_FOR_SIGN_IN = 9001
    }
}