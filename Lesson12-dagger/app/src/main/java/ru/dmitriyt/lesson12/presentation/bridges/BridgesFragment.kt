package ru.dmitriyt.lesson12.presentation.bridges

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson12.R
import ru.dmitriyt.lesson12.databinding.FragmentBridgesBinding
import ru.dmitriyt.lesson12.presentation.BaseFragment

class BridgesFragment : BaseFragment(R.layout.fragment_bridges) {
    private val binding by viewBinding(FragmentBridgesBinding::bind)
    private val viewModel: BridgesViewModel by appViewModels()

    private val bridgesAdapter = BridgesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadBridges()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = bridgesAdapter
        viewModel.bridgesLiveData.observe(viewLifecycleOwner) { bridges ->
            bridgesAdapter.submitList(bridges)
        }
    }

    companion object {
        fun newInstance(): BridgesFragment {
            return BridgesFragment()
        }
    }
}