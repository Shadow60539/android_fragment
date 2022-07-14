package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.*

class CustomDialogFragment : DialogFragment() {

    private lateinit var etUsername: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var btnDone: Button
    private lateinit var listener: DialogListener.CustomDialogListener


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_custom_dialog, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val calender: Calendar = Calendar.getInstance()
        etUsername = view.findViewById<EditText?>(R.id.etUsername)
        showSoftKeyboard()
        btnDone = view.findViewById<Button?>(R.id.btnDone)
            .apply { setOnClickListener() { onDonePressed() } }
        checkBox = view.findViewById(R.id.checkBox)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun showSoftKeyboard() {
        etUsername.requestFocus()
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
    }

    fun setCallbackListener(listener: DialogListener.CustomDialogListener) {
        this.listener = listener
    }

    private fun onDonePressed() {
        if (etUsername.text.isEmpty()) {
            Toast.makeText(activity, "Enter a valid username", Toast.LENGTH_SHORT).show()
            return
        }

        if (!checkBox.isChecked) {
            Toast.makeText(activity, "Check terms and conditions", Toast.LENGTH_SHORT).show()
            return
        }
        listener.onDonePressed(etUsername.text.toString())
        dismiss()
    }
}