package ru.dmitriyt.lesson4

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.dmitriyt.lesson4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }
    private val itemsAdapter = ItemsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        binding.toolbar.menu.findItem(R.id.settings).setOnMenuItemClickListener {
            Toast.makeText(this, "Открыли настройки", Toast.LENGTH_SHORT).show()
            true
        }
        binding.recyclerViewUsers.adapter = itemsAdapter.apply {
            onProductClick = {
                Toast.makeText(this@MainActivity, it.name, Toast.LENGTH_SHORT).show()
            }
            userListener = UserListener { user ->
                Toast.makeText(this@MainActivity, user.surname, Toast.LENGTH_SHORT).show()
            }
        }
        itemsAdapter.setList(
            listOf(
                *List(5) { position ->
                    ListItem.UserItem(
                        User(
                            id = position.toString(),
                            name = "Name $position",
                            surname = "Surname $position",
                        )
                    )
                }.toTypedArray(),
                *List(5) { position ->
                    ListItem.ProductItem(
                        Product(
                            id = position.toString(),
                            name = "Product $position",
                        )
                    )
                }.toTypedArray(),
            )
        )
    }
}