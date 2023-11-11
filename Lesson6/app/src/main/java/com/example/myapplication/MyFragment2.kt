package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class MyFragment2: Fragment(R.layout.my_fragment_2) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val a = arguments?.getInt(ARG_KEY)
    }

    companion object {

        private const val ARG_KEY = "arg_key"

        fun createInstance(arg: Int): MyFragment2 {
            return MyFragment2().also {
                it.arguments = Bundle().apply {
                    putInt(ARG_KEY, arg)
                }
            }
        }
    }
}