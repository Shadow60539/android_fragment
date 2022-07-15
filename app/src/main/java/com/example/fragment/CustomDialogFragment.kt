package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment


class CustomDialogFragment : DialogFragment() {
    private val helper = DialogHelper(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return helper.onCreateView(inflater, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        helper.onViewCreated(view, requireActivity())
        super.onViewCreated(view, savedInstanceState)
    }

    fun setListener(listener: DialogListener.CustomDialogListener) {
        helper.setCallbackListener(listener)
    }
}