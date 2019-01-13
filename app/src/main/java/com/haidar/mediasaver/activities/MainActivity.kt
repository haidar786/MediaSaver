package com.haidar.mediasaver.activities

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.haidar.mediasaver.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        drawer()
        navigation()
        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun navigation() {
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_controller_fragment) as NavHostFragment? ?: return

        //Set up action bar
        val navController = host.navController
        setupActionBar(navController)

        setupNavigationMenu(navController)


    }

    private fun setupNavigationMenu(navController: NavController) {
        nav_view.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

    private fun setupActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this,navController,drawer_layout)
    }

    private fun drawer() {
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }*/
        return NavigationUI.onNavDestinationSelected(item,
            Navigation.findNavController(this,R.id.nav_controller_fragment))
        || super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawer_layout.closeDrawer(GravityCompat.START)
        return NavigationUI.onNavDestinationSelected(item,
            Navigation.findNavController(this, R.id.nav_controller_fragment))
                || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.nav_controller_fragment),drawer_layout)
    }
}
