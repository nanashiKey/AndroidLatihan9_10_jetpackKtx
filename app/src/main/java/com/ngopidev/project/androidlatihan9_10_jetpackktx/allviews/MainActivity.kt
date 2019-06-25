package com.ngopidev.project.androidlatihan9_10_jetpackktx.allviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.ngopidev.project.androidlatihan9_10_jetpackktx.R

class MainActivity : AppCompatActivity() {
    private lateinit var navigationController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationController = findNavController(R.id.peopleListFragment)
        NavigationUI.setupActionBarWithNavController(this, navigationController)
    }

    override fun onSupportNavigateUp() = navigationController.navigateUp()
}
