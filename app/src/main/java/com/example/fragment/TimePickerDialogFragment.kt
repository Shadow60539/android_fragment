package com.example.fragment

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerDialogFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    private lateinit var listener: DialogListener.TimePickerDialogListener


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hh = calendar.get(Calendar.HOUR_OF_DAY)
        val mm = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(requireActivity(), this, hh, mm, false)
    }


    override fun onTimeSet(p0: TimePicker?, hh: Int, mm: Int) {
        listener.onTimeSelected(hh, mm)
    }

    fun setCallbackListener(listener: DialogListener.TimePickerDialogListener) {
        this.listener = listener
    }

}