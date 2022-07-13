package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        btnLogin.setOnClickListener() {
            val bundle = Bundle()
            bundle.putString(LoginFragmentListener.nameKey(), editTextUsername.text.toString())
            listener.onLoginPressed(bundle)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    fun setFragmentListener(listener: LoginFragmentListener) {
        this.listener = listener
    }

}