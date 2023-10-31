package ru.dmitriyt.lesson4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson4.databinding.ItemProductBinding

class ProductViewHolder(
    parent: ViewGroup,
    private val onItemClick: (Product) -> Unit,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false),
) {
    private val binding by viewBinding(ItemProductBinding::bind)

    fun bind(product: Product) = with(binding) {
        root.setOnClickListener {
            onItemClick(product)
        }
        textViewId.text = "${product.id} : ${product.name}"
    }
}