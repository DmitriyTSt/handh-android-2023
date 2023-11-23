package ru.dmitriyt.lesson9

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson9.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::bind)

    private val numberReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val number = intent?.getIntExtra(TestService.KEY_NUMBER, 0)
            Log.d("NumberReceiver", "onReceive = $number")
            Toast.makeText(
                context,
                "receiver $number",
                Toast.LENGTH_SHORT,
            ).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.buttonStart.setOnClickListener {
            startService(TestService.createStartIntent(this, Random.nextInt()))
        }
        binding.buttonStop.setOnClickListener {
            stopService(TestService.createStartIntent(this, Random.nextInt()))
        }

        registerReceiver(numberReceiver, IntentFilter(NUMBER_RECEIVER_ACTION))
    }

    override fun onDestroy() {
        unregisterReceiver(numberReceiver)
        super.onDestroy()
    }

    companion object {
        const val NUMBER_RECEIVER_ACTION = "ru.dmitriyt.lesson9.NUMBER_RECEIVER_ACTION"
    }
}
