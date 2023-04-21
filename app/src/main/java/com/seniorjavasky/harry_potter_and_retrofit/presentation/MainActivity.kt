package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.ActivityMainBinding
import com.seniorjavasky.harry_potter_and_retrofit.databinding.ActivityMainWithDrawerBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainWithDrawerBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainWithDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
        binding.activityMain.navView.setupWithNavController(navController)

        binding.drawerNavView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.drawer_sign_up -> {
                    Toast.makeText(this, "SignUp", Toast.LENGTH_LONG).show()
                }
                R.id.drawer_sign_in -> {
                    Toast.makeText(this, "SignIn", Toast.LENGTH_LONG).show()
                }
                R.id.drawer_sign_out -> {
                    Toast.makeText(this, "SignOut", Toast.LENGTH_LONG).show()
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