package com.example.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), LoginFragmentListener {

    private val fm: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        firstFragment.setFragmentListener(this)
        if (savedInstanceState == null) {
            showFragment(firstFragment)
        } else {
            showFragment(secondFragment)
        }
    }

    private fun showFragment(fragment: Fragment) {
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.fragment, fragment)
        ft.commit()
    }


    override fun onLoginPressed(bundle: Bundle) {
        val ft: FragmentTransaction = fm.beginTransaction()
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        ft.replace(R.id.fragment, secondFragment)
        ft.addToBackStack(null)
        ft.commit()
    }

}