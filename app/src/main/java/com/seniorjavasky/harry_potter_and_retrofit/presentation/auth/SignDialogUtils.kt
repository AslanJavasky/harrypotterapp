package com.seniorjavasky.harry_potter_and_retrofit.presentation.auth


import android.view.View
import androidx.appcompat.app.AlertDialog
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.SignDialogBinding
import com.seniorjavasky.harry_potter_and_retrofit.presentation.MainActivity

class SignDialogUtils(
    val context: MainActivity
) {

    val authUtils = AuthUtils(context)

    val binding = SignDialogBinding.inflate(context.layoutInflater)
    val view = binding.root
    val alertDialog = AlertDialog.Builder(context)
        .setView(view)
        .create()

    fun showAlertDialog(type: String) {
        when (type) {
            TYPE_SIGN_UP -> {
                binding.tvForSign.text =
                    context.resources.getString(R.string.tv_sign_up)
                binding.btnSign.text =
                    context.resources.getString(R.string.sign_up)
                binding.tvForgotPasword.visibility = View.GONE
            }
            TYPE_SIGN_IN -> {
                binding.tvForSign.text =
                    context.resources.getString(R.string.tv_sign_in)
                binding.btnSign.text =
                    context.resources.getString(R.string.sign_in)
                binding.tvForgotPasword.visibility = View.VISIBLE
            }
        }
        alertDialog.show()

        binding.btnSign.setOnClickListener {
            val email = binding.edEmail.text.toString()
            val password = binding.edPassword.text.toString()
            val isEmailAndPaswordNotEmpty = email.isNotEmpty() && password.isNotEmpty()
            if (isEmailAndPaswordNotEmpty) {
                when (type) {
                    TYPE_SIGN_UP -> {
                        authUtils.signUpWithEmail(email, password)

                    }
                    TYPE_SIGN_IN -> {
                        authUtils.signInWithEmail(email, password)
                    }

                }
            }
            alertDialog.dismiss()
        }
        binding.tvForgotPasword.setOnClickListener {
            val email=binding.edEmail.text.toString()
            if (email.isNotEmpty()){
                authUtils.resetPasswordForEmail(email)
            }
        }

        binding.btnGoogle.setOnClickListener {
            authUtils.btnGoogleClickListener()
            alertDialog.dismiss()
        }

    }


    companion object {

        const val TYPE_SIGN_UP = "sign up"
        const val TYPE_SIGN_IN = "sign in"


    }

}