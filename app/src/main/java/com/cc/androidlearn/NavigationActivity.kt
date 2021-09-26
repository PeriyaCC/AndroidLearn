package com.cc.androidlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        doLoadGraphToNav()
    }

    private fun doLoadGraphToNav() {
        val navHost = supportFragmentManager.findFragmentById(R.id.hostContainer) as NavHostFragment
        navHost.findNavController().setGraph(R.navigation.nav_learn)
    }
}