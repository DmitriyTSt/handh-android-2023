package ru.dmitriyt.lesson12.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson12.R
import ru.dmitriyt.lesson12.databinding.ActivityMainBinding
import ru.dmitriyt.lesson12.presentation.bridges.BridgesFragment

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view_tag, BridgesFragment.newInstance())
            .commit()
    }
}
