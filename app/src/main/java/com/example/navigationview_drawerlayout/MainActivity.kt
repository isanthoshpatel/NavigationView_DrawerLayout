package com.example.navigationview_drawerlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(frameLayout.id, Home()).commit()

        setSupportActionBar(toolbar)

        var actionbarDrawerTogle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawer.addDrawerListener(actionbarDrawerTogle)
        actionbarDrawerTogle.syncState()

        navigation_view.setNavigationItemSelectedListener(this)
        navigation_view.setCheckedItem(R.id.home)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                supportFragmentManager.beginTransaction().replace(frameLayout.id, Home(), "home").commit()
                drawer.closeDrawer(GravityCompat.START)
            }
            R.id.videos -> {
                supportFragmentManager.beginTransaction().replace(frameLayout.id, Videos()).addToBackStack("home").commit()
                drawer.closeDrawer(GravityCompat.START)
            }
            R.id.ask -> {
                supportFragmentManager.beginTransaction().replace(frameLayout.id, Home()).addToBackStack("home").commit()
                drawer.closeDrawer(GravityCompat.START)
            }
            R.id.share ->{
                Toast.makeText(this@MainActivity,"Sharring.....",Toast.LENGTH_LONG).show()
                drawer.closeDrawer(GravityCompat.START)
            }
            R.id.mail ->{
                Toast.makeText(this@MainActivity,"sending mail.....",Toast.LENGTH_LONG).show()
                drawer.closeDrawer(GravityCompat.START)

            }
        }
        return true // tells that item is clicked
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) drawer.closeDrawer(GravityCompat.START)
        else super.onBackPressed()
    }
}
