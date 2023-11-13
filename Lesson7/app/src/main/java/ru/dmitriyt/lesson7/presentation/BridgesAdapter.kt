package ru.dmitriyt.lesson7.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.dmitriyt.lesson7.data.model.Bridge

class BridgesAdapter : RecyclerView.Adapter<BridgeViewHolder>() {

    private val bridges = mutableListOf<Bridge>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BridgeViewHolder {
        return BridgeViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return bridges.size
    }

    override fun onBindViewHolder(holder: BridgeViewHolder, position: Int) {
        holder.bind(bridges[position])
    }

    fun submitList(bridges: List<Bridge>) {
        this.bridges.clear()
        this.bridges.addAll(bridges)
        notifyDataSetChanged()
    }
}