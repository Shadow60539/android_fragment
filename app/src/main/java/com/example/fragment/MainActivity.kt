package com.example.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private val COUNT_KEY = "COUNT_KEY"
    private val FRAGMENT_KEY = "FRAGMENT_KEY"

    private lateinit var textViewBackStackCounter: TextView

    private val fm: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewBackStackCounter = findViewById<TextView>(R.id.tvBackStackCount)

        showFragment(FirstFragment())
        fm.addOnBackStackChangedListener() {
            textViewBackStackCounter.text = fm.backStackEntryCount.toString()
        }
    }

    private fun showFragment(fragment: Fragment) {
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.fragment, fragment)
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
        textViewBackStackCounter.text = fm.backStackEntryCount.toString()
        super.onBackPressed()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        var currentFragment: Fragment
        var count: String

        savedInstanceState.apply {
            currentFragment = if (getBoolean(FRAGMENT_KEY)) FirstFragment() else SecondFragment()
            count = getString(COUNT_KEY)!!
        }
        textViewBackStackCounter.text = count
        showFragment(currentFragment)
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val isFirst = fm.findFragmentById(R.id.fragment)!! is FirstFragment
        val count = textViewBackStackCounter.text.toString()
        outState.apply {
            putBoolean(FRAGMENT_KEY, isFirst)
            putString(COUNT_KEY, count)
        }
        super.onSaveInstanceState(outState)
    }
}