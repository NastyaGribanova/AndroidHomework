package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.bottomNavigation.CompanionFragment
import com.example.myapplication.bottomNavigation.DoctorFragment
import com.example.myapplication.bottomNavigation.DoctorWhoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation: BottomNavigationView

        val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener {item ->
                when (item.itemId) {
                    R.id.doctor -> {
                        val doctorFragment = DoctorFragment.newInstance()
                        openFragment(doctorFragment)
                        true
                    }
                    R.id.companion -> {
                        val companionFragment = CompanionFragment.newInstance()
                        openFragment(companionFragment)
                        true
                    }
                    R.id.doctorWho -> {
                        val doctorWhoFragment = DoctorWhoFragment.newInstance()
                        openFragment(doctorWhoFragment)
                        true
                    }
                    else -> false
                }
            }
        btv_main.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction().apply { }
        transaction.replace(R.id.container_main, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
