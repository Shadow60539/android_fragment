package com.example.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), CustomDialogListener {

    private val fm: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onShowDialogPressed(view: View) {
        val dialog = CustomDialogFragment()
        dialog.setCallbackListener(this)
        dialog.show(fm, null)
    }

    override fun onDonePressed(name: String) {
        Toast.makeText(this, "Welcome $name", Toast.LENGTH_SHORT).show()
    }
}