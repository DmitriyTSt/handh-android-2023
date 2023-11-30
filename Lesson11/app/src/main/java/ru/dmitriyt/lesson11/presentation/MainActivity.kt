package ru.dmitriyt.lesson11.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson11.R
import ru.dmitriyt.lesson11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::bind)

    private var isAnimated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bridge = Bridge(
            imageRes = R.drawable.ic_launcher_background,
            title = "Название моста",
            description = "Описание моста"
        )
        binding.bridgeRowView.bind(bridge)
        binding.buttonAnimate.setOnClickListener {
            if (isAnimated) {
                binding.circleView.stopAnimation()
            } else {
                binding.circleView.startAnimation()
            }
            isAnimated = !isAnimated
        }
    }
}
