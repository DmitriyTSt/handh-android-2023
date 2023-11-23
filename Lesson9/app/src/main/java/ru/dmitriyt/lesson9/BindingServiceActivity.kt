package ru.dmitriyt.lesson9

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.dmitriyt.lesson9.databinding.ActivityBindingServiceBinding

class BindingServiceActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityBindingServiceBinding::bind)

    private val serviceIntent by lazy { Intent(this, BindingService::class.java) }

    private var myBinder: BindingService.MyBinder? = null

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, binder: IBinder?) {
            Log.d("CONNECTION", "onServiceConnected")
            myBinder = binder as? BindingService.MyBinder
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.d("CONNECTION", "onServiceDisconnected")
            // не вызовется если завершить самому
            myBinder = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binding_service)
        binding.buttonStart.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }
        }
        binding.buttonStop.setOnClickListener {
            stopService(serviceIntent)
        }
        binding.buttonBind.setOnClickListener {
            bindService(serviceIntent, connection, BIND_AUTO_CREATE)
        }
        binding.buttonUnbind.setOnClickListener {
            if (myBinder != null) {
                unbindService(connection)
                myBinder = null
            }
        }
        binding.buttonTest.setOnClickListener {
            myBinder?.service?.test("123456")
        }
    }

    override fun onDestroy() {
        if (myBinder != null) {
            unbindService(connection)
        }
        super.onDestroy()
    }
}