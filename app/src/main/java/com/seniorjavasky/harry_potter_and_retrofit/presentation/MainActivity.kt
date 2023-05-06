package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.ActivityMainWithDrawerBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainWithDrawerBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainWithDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        App.INSTANCE.permissionService.initMainActivityContext(this)
        App.INSTANCE.permissionService.checkPermissions()

        initAuth()

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
        binding.activityMain.navView.setupWithNavController(navController)

        binding.drawerNavView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.drawer_sign_up -> {
                    signUpIn()
                }
                R.id.drawer_sign_in -> {
                    signUpIn()
                }
                R.id.drawer_sign_out -> {
                    signOut()
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()

    }



    private fun initAuth() {
        App.INSTANCE.firebaseInstance.initAuthUtils(this)
    }

    private fun signUpIn() {
        App.INSTANCE.firebaseInstance.authUtils.signUpIn()
    }

    private fun signOut() {
        App.INSTANCE.firebaseInstance.authUtils.signOut()
    }
}