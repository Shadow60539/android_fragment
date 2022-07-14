package com.example.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private lateinit var listener: DialogListener.DatePickerDialogListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val yy = calendar.get(Calendar.YEAR)
        val mm = calendar.get(Calendar.MONTH)
        val dd = calendar.get(Calendar.DAY_OF_MONTH)


        return DatePickerDialog(requireActivity(), this, yy, mm, dd)
    }

    fun setCallbackListener(listener: DialogListener.DatePickerDialogListener) {
        this.listener = listener
    }

    override fun onDateSet(p0: DatePicker?, yy: Int, mm: Int, dd: Int) {
        listener.onDateSelected(yy, mm, dd)
    }

}