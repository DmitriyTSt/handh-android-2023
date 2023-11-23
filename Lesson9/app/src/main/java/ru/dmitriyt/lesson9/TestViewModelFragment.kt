package ru.dmitriyt.lesson9

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson9.databinding.FragmentTestViewModelBinding

class TestViewModelFragment : Fragment(R.layout.fragment_test_view_model) {

    private val binding by viewBinding(FragmentTestViewModelBinding::bind)
    private val viewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.testJob()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.numberLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is LoadState.Data -> {
//                    TODO()
                    binding.textViewNumber.text = state.data.toString()
                }
                is LoadState.Error -> {
//                    TODO()
                }
                is LoadState.Loading -> {
//                    TODO()
                }
            }

        }
    }
}