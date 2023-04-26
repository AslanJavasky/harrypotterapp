package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.ActivityMainWithDrawerBinding
import com.seniorjavasky.harry_potter_and_retrofit.presentation.auth.AuthUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainWithDrawerBinding
    private lateinit var navController: NavController
    private lateinit var authUtils: AuthUtils


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainWithDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        authUtils= AuthUtils (this)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
        binding.activityMain.navView.setupWithNavController(navController)

        binding.drawerNavView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.drawer_sign_up -> {
                  authUtils.signUpIn()
                }
                R.id.drawer_sign_in -> {
                    authUtils.signUpIn()
                }
                R.id.drawer_sign_out -> {
                    authUtils.signOut()
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()

    }


}