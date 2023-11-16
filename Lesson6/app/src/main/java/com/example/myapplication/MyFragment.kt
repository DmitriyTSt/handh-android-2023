package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class MyFragment : Fragment(R.layout.my_fragment) {

    private val fragments = List(3) { MyFragment2() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ViewPager2>(R.id.viewPager).apply {
            this.adapter = MyStateAdapter(this@MyFragment).apply {
                bind(fragments)
            }
        }

        (activity as? MyActivity)?.activityFun()
    }

    override fun onDestroyView() {
        view?.findViewById<ViewPager2>(R.id.viewPager).apply {
            this?.adapter = null
        }
        super.onDestroyView()
    }

    fun fragmentFun() {

    }
}