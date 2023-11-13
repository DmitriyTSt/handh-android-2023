package ru.dmitriyt.lesson7.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.dmitriyt.lesson7.R
import ru.dmitriyt.lesson7.data.ApiClient
import ru.dmitriyt.lesson7.databinding.FragmentMainBinding
import kotlin.system.measureTimeMillis

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)

    private val bridgesAdapter = BridgesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val job = lifecycleScope.launch {
            val time = measureTimeMillis {
                val userRequest = async { getUser() }
                val productRequest = async { getProduct() }
                val user = userRequest.await()
                val product = withContext(Dispatchers.Default) {
                    productRequest.join()
                }
                val userAndProduct = user to product
            }
            Log.d("TAG", "lifecycleScope.launch $time ms")
        }
        lifecycleScope.launch {
            delay(500)
            job.cancel()
        }


        binding.recyclerView.adapter = bridgesAdapter
        loadBridges()
    }

    private fun loadBridges() {
        lifecycleScope.launch {
            binding.progressBar.isVisible = true
            val bridges = ApiClient.apiService.getBridges()
            bridgesAdapter.submitList(bridges)
            binding.progressBar.isVisible = false
        }
    }

    private suspend fun getUser(): Int = withContext(Dispatchers.IO) {
        delay(1000)
        Log.d("TAG", "getUser end")
        123
    }

    private suspend fun getProduct() {
        try {
            delay(2000)
            Log.d("TAG", "getProduct end")
        } catch (e: Exception) {
            Log.d("TAG", "$e")
        }
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}
