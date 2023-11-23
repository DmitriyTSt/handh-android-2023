package ru.dmitriyt.lesson9

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TestService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d("TestService", "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("TestService", "onStartCommand ${intent?.getIntExtra(KEY_NUMBER, 0)}")
        someAction(intent?.getIntExtra(KEY_NUMBER, 0) ?: 0)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        Log.d("TestService", "onDestroy")
        super.onDestroy()
    }

    private fun someAction(number: Int) {
        Thread {
            repeat(5) {
                Thread.sleep(1000)
                Log.d("TestService", "someAction sleep ${it + 1}")
            }
            val intent = Intent(MainActivity.NUMBER_RECEIVER_ACTION).apply {
                putExtra(KEY_NUMBER, number)
            }
            sendBroadcast(intent)
            stopSelf()
        }.start()
    }

    companion object {
        const val KEY_NUMBER = "key_number"

        fun createStartIntent(context: Context, number: Int): Intent {
            return Intent(context, TestService::class.java).apply {
                putExtra(KEY_NUMBER, number)
            }
        }
    }
}