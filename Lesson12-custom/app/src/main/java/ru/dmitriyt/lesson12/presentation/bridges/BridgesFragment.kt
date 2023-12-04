package ru.dmitriyt.lesson12.presentation.bridges

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson12.BridgesApplication
import ru.dmitriyt.lesson12.R
import ru.dmitriyt.lesson12.databinding.FragmentBridgesBinding

class BridgesFragment : Fragment(R.layout.fragment_bridges) {
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

    inline fun <reified VM : ViewModel> appViewModels() = createViewModelLazy(VM::class, { viewModelStore }) {
        (requireContext().applicationContext as BridgesApplication).applicationComponent.provideCustomViewModelFactory()
    }

    companion object {
        fun newInstance(): BridgesFragment {
            return BridgesFragment()
        }
    }
}