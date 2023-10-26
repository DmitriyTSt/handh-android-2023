package ru.dmitriyt.lesson3

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import ru.dmitriyt.lesson3.R
import ru.dmitriyt.lesson3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }
    private var buttonHelloWorld: Button? = null

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
    }
}