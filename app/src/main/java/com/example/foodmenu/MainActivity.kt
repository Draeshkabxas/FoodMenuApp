package com.example.foodmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.foodFragmentContainer) as NavHostFragment
            navController = navHostFragment.findNavController()

            //Give the action bar the correct title for the current screen (this uses the fragment label)
            appBarConfiguration = AppBarConfiguration(
                setOf(R.id.foodXFragment, R.id.settingsXFragment)
            )
            //Connects the action bar with the nav controller
            setupActionBarWithNavController(navController, appBarConfiguration)

            binding.navBtn.setupWithNavController(navController)
        }

    //gives functionality to the back button on the action bar
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

}
