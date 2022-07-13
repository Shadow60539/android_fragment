package com.example.fragment

import android.os.Bundle

interface LoginFragmentListener {
    companion object {
        fun nameKey() = "NAME_KEY"
    }

    fun onLoginPressed(bundle: Bundle)
}