package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.ui.griffindor.GriffindorFragment
import com.example.myapplication.ui.hafflepuff.HafflepuffFragment
import com.example.myapplication.ui.hogwarts.HogwartsFragment
import com.example.myapplication.ui.ravenclaw.RavenclawFragment
import com.example.myapplication.ui.slytherin.SlytherinFragment
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_hogwarts -> {
                    navigateToFragment(HogwartsFragment.newInstance())
                }
                R.id.nav_ravenclaw -> {
                    navigateToFragment(RavenclawFragment.newInstance())
                }
                R.id.nav_griffindor -> {
                    navigateToFragment(GriffindorFragment.newInstance())
                }
                R.id.nav_hufflepuff -> {
                    navigateToFragment(HafflepuffFragment.newInstance())
                }
                R.id.nav_slytherin -> {
                    navigateToFragment(SlytherinFragment.newInstance())
                }
                else -> {
                }
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        when {
            drawer.isDrawerOpen(GravityCompat.START) -> drawer.closeDrawer(GravityCompat.START)
            else -> super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_first_drawer, menu)
        return true
    }

    private fun navigateToFragment(fragmentToNavigate: Fragment): Boolean {
        supportFragmentManager.also {
            it.beginTransaction().apply {
                replace(R.id.frameLayout, fragmentToNavigate)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                addToBackStack(null)
                commit()
            }
        }
        return true
    }

    private fun setUpDrawerLayout() {
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.Hogwarts, R.string.Slytherin)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }
}
