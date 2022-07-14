package com.example.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), DialogListener.CustomDialogListener,
    DialogListener.DatePickerDialogListener, DialogListener.TimePickerDialogListener {

    private val fm: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onShowCustomDialogPressed(view: View) {
        val dialog = CustomDialogFragment()
        dialog.setCallbackListener(this)
        dialog.show(fm, null)
    }


    override fun onShowDatePickerDialogPressed(view: View) {
        val dialog = DatePickerDialogFragment()
        dialog.setCallbackListener(this)
        dialog.show(fm, null)
    }

    override fun onShowTimePickerDialogPressed(view: View) {
        val dialog = TimePickerDialogFragment()
        dialog.setCallbackListener(this)
        dialog.show(fm, null)
    }

    override fun onDonePressed(name: String) {
        Toast.makeText(this, "Welcome $name", Toast.LENGTH_SHORT).show()
    }

    override fun onDateSelected(yy: Int, mm: Int, dd: Int) {
        Toast.makeText(this, "$dd / $mm / $yy", Toast.LENGTH_SHORT).show()
    }

    override fun onTimeSelected(hh: Int, mm: Int) {
        Toast.makeText(this, "$hh : $mm", Toast.LENGTH_SHORT).show()
    }
}