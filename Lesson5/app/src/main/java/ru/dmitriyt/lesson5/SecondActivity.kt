package ru.dmitriyt.lesson5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivitySecondBinding::bind)

    private val stringValue by lazy { intent.getStringExtra(KEY_EDIT_TEXT_VALUE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding.textView.text = stringValue
    }

    companion object {
        private const val KEY_EDIT_TEXT_VALUE = "key_edit_text_value"

        fun createStartIntent(context: Context, value: String): Intent {
            return Intent(context, SecondActivity::class.java).apply {
                putExtra(KEY_EDIT_TEXT_VALUE, value)
            }
        }
    }
}