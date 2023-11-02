package ru.dmitriyt.lesson5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson5.databinding.ActivityMainBinding

private const val KEY_TEXT_IS_VISIBLE = "key_text_is_visible"

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind)

    private val launcher = registerForActivityResult(
        ThirdActivityContract()
    ) { query ->
        binding.buttonActForResult.text = query
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.textViewThis.text = this.toString()

        binding.button.setOnClickListener {
            startActivity(
                SecondActivity.createStartIntent(
                    this,
                    binding.editText.text?.toString().orEmpty(),
                )
            )
            binding.textViewThis.isVisible = !binding.textViewThis.isVisible
        }
        binding.buttonActForResult.setOnClickListener {
            launcher.launch(Unit)
        }
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(KEY_TEXT_IS_VISIBLE, binding.textViewThis.isVisible)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.textViewThis.isVisible = savedInstanceState.getBoolean(KEY_TEXT_IS_VISIBLE)
    }
}