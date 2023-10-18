package ru.dmitriyt.lesson1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var buttonHelloWorld: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonHelloWorld = findViewById<Button>(R.id.buttonHelloWorld)
        findViewById<Button>(R.id.buttonHelloWorld).setOnClickListener {
            Toast.makeText(this, findViewById<EditText>(R.id.editText).text.toString(), Toast.LENGTH_SHORT).show()
        }
        findViewById<TextView>(R.id.textViewDescription).text = "123"
    }
}