package com.seniorjavasky.harry_potter_and_retrofit.presentation.auth


import androidx.appcompat.app.AlertDialog
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.SignDialogBinding
import com.seniorjavasky.harry_potter_and_retrofit.presentation.MainActivity

class SignDialogUtils(
    val context: MainActivity
) {

    val binding = SignDialogBinding.inflate(context.layoutInflater)
    val view = binding.root
    fun showAlertDialog(type: String) {
        when(type){
            TYPE_SIGN_UP -> {
                binding.tvForSign.text=
                    context.resources.getString(R.string.tv_sign_up)
                binding.btnSign.text=
                    context.resources.getString(R.string.sign_up)
            }
            TYPE_SIGN_IN -> {
                binding.tvForSign.text=
                    context.resources.getString(R.string.tv_sign_in)
                binding.btnSign.text=
                    context.resources.getString(R.string.sign_in)
            }
        }

        AlertDialog.Builder(context)
            .setView(view)
            .show()
    }

    companion object {

        const val TYPE_SIGN_UP = "sign up"
        const val TYPE_SIGN_IN = "sign in"


    }

}