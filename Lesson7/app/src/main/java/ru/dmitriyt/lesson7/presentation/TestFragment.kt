package ru.dmitriyt.lesson7.presentation

import androidx.fragment.app.Fragment
import ru.dmitriyt.lesson7.R

class TestFragment : Fragment(R.layout.fragment_test) {

    companion object {
        fun newInstance(): TestFragment {
            return TestFragment()
        }
    }
}