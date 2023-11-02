package ru.dmitriyt.lesson5

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson5.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityThirdBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        binding.buttonOk.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(KEY_QUERY, binding.editTextQuery.text?.toString().orEmpty())
            })
            finish()
        }
    }

    companion object {
        const val KEY_QUERY = "key_query"

        fun createStartIntent(context: Context): Intent {
            return Intent(context, ThirdActivity::class.java)
        }
    }
}