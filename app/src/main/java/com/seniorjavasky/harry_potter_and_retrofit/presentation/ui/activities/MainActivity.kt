package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.ActivityMainWithDrawerBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainWithDrawerBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainWithDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        App.INSTANCE.permissionService.initMainActivityContext(this)
        App.INSTANCE.permissionService.checkPermissions()

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

//        MessagingUtils().logToken()

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()

    }


    private fun isDoneAuth(): Boolean =
        App.INSTANCE.firebaseInstance.authUtils.auth.currentUser != null

    private fun signUpIn() {
        if (!isDoneAuth()) {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun signOut() {
        App.INSTANCE.firebaseInstance.authUtils.authUI
            .signOut(this)

    }
}