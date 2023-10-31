package ru.dmitriyt.lesson4

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

private const val TYPE_USER = 0
private const val TYPE_PRODUCT = 1

class ItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = mutableListOf<ListItem>()

    lateinit var onProductClick: (Product) -> Unit
    lateinit var userListener: UserListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_USER -> UserViewHolder(parent, userListener)
            TYPE_PRODUCT -> ProductViewHolder(parent, onProductClick)
            else -> error("ViewType not supported")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserViewHolder -> holder.bind((items[position] as ListItem.UserItem).user)
            is ProductViewHolder -> holder.bind((items[position] as ListItem.ProductItem).product)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is ListItem.UserItem) {
            TYPE_USER
        } else {
            TYPE_PRODUCT
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(users: List<ListItem>) {
        this.items.clear()
        this.items.addAll(users)
        notifyDataSetChanged()
    }
}