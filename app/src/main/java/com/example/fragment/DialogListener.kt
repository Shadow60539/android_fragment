package com.example.fragment

import android.view.View

sealed interface DialogListener {
    interface CustomDialogListener : DialogListener {
        fun onShowCustomDialogPressed(view: View)
        fun onShowBottomSheetPressed(view: View)
        fun onDonePressed(name: String)
    }

    interface DatePickerDialogListener : DialogListener {
        fun onShowDatePickerDialogPressed(view: View)
        fun onDateSelected(yy: Int, mm: Int, dd: Int)
    }

    interface TimePickerDialogListener : DialogListener {
        fun onShowTimePickerDialogPressed(view: View)
        fun onTimeSelected(hh: Int, mm: Int)
    }
}