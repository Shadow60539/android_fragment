package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheet : BottomSheetDialogFragment() {
    private val helper = DialogHelper(this)

    companion object {
        val TAG = "MOALBOTTOMSHEET"
    }

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