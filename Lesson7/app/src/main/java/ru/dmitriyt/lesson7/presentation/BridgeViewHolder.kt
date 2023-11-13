package ru.dmitriyt.lesson7.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson7.R
import ru.dmitriyt.lesson7.data.model.Bridge
import ru.dmitriyt.lesson7.databinding.ItemBridgeBinding

class BridgeViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_bridge, null, false)
) {
    private val binding by viewBinding(ItemBridgeBinding::bind)

    fun bind(item: Bridge) {
        binding.root.text = item.name
    }
}