package ru.dmitriyt.lesson7.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson7.R
import ru.dmitriyt.lesson7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind)

    private var isAdded: Boolean = false
    private val fragment: TestFragment by lazy { TestFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.button.setOnClickListener {
            if (isAdded) {
                supportFragmentManager.beginTransaction()
                    .remove(fragment)
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainerView, fragment)
                    .commit()
            }
            isAdded = !isAdded
        }
    }
}