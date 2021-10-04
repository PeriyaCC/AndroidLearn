package com.cc.androidlearn

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val navHost = supportFragmentManager.findFragmentById(R.id.navHostBottomNav) as NavHostFragment
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navHost.findNavController(), appBarConfiguration)
        btmNavView.setupWithNavController(navHost.findNavController())
    }

    private fun loadResource(){
        //color
        val color = ContextCompat.getColor(this, R.color.black)
        //string
        val str = resources.getString(R.string.app_name)
        //dimens
        val dimen = resources.getDimension(R.dimen.margin_10dp)
        //drawable
        val drawable = ContextCompat.getDrawable(this, R.drawable.btn_circle_green)
    }

    private fun showMessage(msg : String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}