package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class FirstFragment :
    Fragment() {

    private lateinit var editTextUsername: EditText
    private lateinit var btnLogin: Button

    lateinit var listener: LoginFragmentListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onResume() {
        super.onResume()
        activity?.title = "Login";
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        editTextUsername = view.findViewById(R.id.etName)!!
        btnLogin = view.findViewById(R.id.btnLogin)!!
        editTextUsername.setOnEditorActionListener() { _, actionId: Int, _ ->
            val isDonePressed = actionId == EditorInfo.IME_ACTION_DONE
            if (isDonePressed) onLoginListener()
            false
        }
        btnLogin.setOnClickListener() { onLoginListener() }
        super.onViewCreated(view, savedInstanceState)
    }

    fun setFragmentListener(listener: LoginFragmentListener) {
        this.listener = listener
    }

    private fun onLoginListener() {
        val bundle = Bundle()
        bundle.putString(LoginFragmentListener.nameKey(), editTextUsername.text.toString())
        listener.onLoginPressed(bundle)
    }

}