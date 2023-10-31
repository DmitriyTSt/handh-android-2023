package ru.dmitriyt.lesson4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson4.databinding.ItemUserBinding

class UserViewHolder(
    parent: ViewGroup,
    private val userListener: UserListener,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false),
) {
    private val binding by viewBinding(ItemUserBinding::bind)

    fun bind(user: User) = with(binding) {
        root.setOnClickListener {
            userListener.onUserClick(user)
        }
        textViewId.text = "ID: ${user.id}"
        textViewFullName.text = root.context.getString(R.string.full_name_template, user.name, user.surname)
    }
}