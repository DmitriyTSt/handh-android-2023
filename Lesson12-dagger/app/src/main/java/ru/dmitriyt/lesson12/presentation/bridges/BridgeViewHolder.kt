package ru.dmitriyt.lesson12.presentation.bridges

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson12.R
import ru.dmitriyt.lesson12.databinding.ItemBridgeBinding
import ru.dmitriyt.lesson12.presentation.Bridge

class BridgeViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_bridge, parent, false)
) {
    private val binding by viewBinding(ItemBridgeBinding::bind)

    fun bind(item: Bridge) {
        binding.root.bind(item)
    }
}