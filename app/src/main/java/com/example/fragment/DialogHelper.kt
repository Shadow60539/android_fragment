package com.example.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class DialogHelper(private val dialogFragment: DialogFragment) {

    lateinit var etUsername: EditText
    lateinit var checkBox: CheckBox
    lateinit var btnDone: Button
    lateinit var listener: DialogListener.CustomDialogListener
    lateinit var context: Context


    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): View? {
        return inflater.inflate(R.layout.fragment_custom_dialog, container, false)
    }


    fun onViewCreated(view: View, context: Context) {
        etUsername = view.findViewById<EditText?>(R.id.etUsername)
        showSoftKeyboard()
        btnDone = view.findViewById<Button?>(R.id.btnDone)
            .apply { setOnClickListener() { onDonePressed() } }
        checkBox = view.findViewById(R.id.checkBox)
        this.context = context
    }

    private fun showSoftKeyboard() {
        etUsername.requestFocus()
        dialogFragment.dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
    }

    fun setCallbackListener(listener: DialogListener.CustomDialogListener) {
        this.listener = listener
    }


    private fun onDonePressed() {
        if (etUsername.text.isEmpty()) {
            Toast.makeText(context, "Enter a valid username", Toast.LENGTH_SHORT).show()
            return
        }

        if (!checkBox.isChecked) {
            Toast.makeText(context, "Check terms and conditions", Toast.LENGTH_SHORT).show()
            return
        }
        listener.onDonePressed(etUsername.text.toString())
        dialogFragment.dismiss()
    }

}