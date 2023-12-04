package ru.dmitriyt.lesson12.presentation.bridges

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.dmitriyt.lesson12.presentation.Bridge

class BridgesAdapter : RecyclerView.Adapter<BridgeViewHolder>() {

    private val items = mutableListOf<Bridge>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BridgeViewHolder {
        return BridgeViewHolder(parent)
    }

    override fun onBindViewHolder(holder: BridgeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(bridges: List<Bridge>) {
        items.clear()
        items.addAll(bridges)
        notifyDataSetChanged()
    }
}