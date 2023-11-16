package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyStateAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val items = mutableListOf<Fragment>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }

    fun bind(items: List<Fragment>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}