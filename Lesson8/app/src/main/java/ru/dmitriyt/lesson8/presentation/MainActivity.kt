package ru.dmitriyt.lesson8.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import ru.dmitriyt.lesson8.R
import ru.dmitriyt.lesson8.databinding.ActivityMainBinding
import ru.dmitriyt.lesson8.presentation.data.db.DatabaseClient
import ru.dmitriyt.lesson8.presentation.data.db.entity.CarEntity
import java.util.UUID

private const val PREF_NAME = "pref_file"
private const val KEY_PREF_VALUE = "key_pref_value"

class MainActivity : AppCompatActivity() {

    private val sharedPreferences by lazy {
        getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        with(binding) {
            buttonSave.setOnClickListener {
                lifecycleScope.launch {
                    DatabaseClient.carDao(this@MainActivity).save(
                        CarEntity(
                            id = UUID.randomUUID().toString(),
                            type = "type",
                            model = editText.text.toString(),
                            color = "red",
                            number = "2",
                        )
                    )
                }
            }
            buttonRestore.setOnClickListener {
                lifecycleScope.launch {
                    DatabaseClient.carDao(this@MainActivity)
                        .deleteById("79200a79-f258-4f3b-ab4b-5042bc0956db")
                }
//                val value = sharedPreferences.getString(KEY_PREF_VALUE, "")
//                textView.text = value
            }
            val flow = flow<String> {
                emit(UUID.randomUUID().toString())
                delay(100)
                emit(UUID.randomUUID().toString())
                repeat(5) {
                    delay(1000)
                    emit(UUID.randomUUID().toString())
                }
            }
            lifecycleScope.launch {
                try {
                    DatabaseClient.carDao(this@MainActivity).getCarsFlow().collect { cars ->
                        textView.text = cars.joinToString("\n") { it.toString() }
                    }
                } catch (e: Exception) {
                    textView.text = "ERROR ${e.message}"
                }

//                flow.collect {
//                    textView.append("$it\n")
//                }
            }
        }
    }
}

interface NavigationController {
    fun navigate(fragment: Fragment)
    fun back()
}

class MyFragment : Fragment() {

    private var navigationController: NavigationController? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigationController = (parentFragment as? NavigationController)
            ?: (activity as? NavigationController)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}