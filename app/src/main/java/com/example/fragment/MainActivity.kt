package com.example.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private val fm: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFirstFragment()
        fm.addOnBackStackChangedListener() {
            findViewById<TextView>(R.id.tvBackStackCount).text = fm.backStackEntryCount.toString()
        }
    }

    private fun addFirstFragment() {
        val ft: FragmentTransaction = fm.beginTransaction()
        val firstFragment = FirstFragment()
        ft.add(R.id.fragment, firstFragment)
        ft.commit()
    }

    fun replaceFragment(v: View) {
        val ft: FragmentTransaction = fm.beginTransaction()
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val currentFragment = fm.findFragmentById(R.id.fragment)!!
        if (currentFragment is FirstFragment) {
            ft.replace(R.id.fragment, secondFragment)
        } else {
            ft.replace(R.id.fragment, firstFragment)
        }
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onBackPressed() {
        findViewById<TextView>(R.id.tvBackStackCount).text = fm.backStackEntryCount.toString()
        super.onBackPressed()
    }
}