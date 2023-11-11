package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

private const val FRAGMENT_TAG = "myfragment"

class MyActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_activity)

        val myFragment = MyFragment()
        val fragment2 = MyFragment2()

        findViewById<MaterialButton>(R.id.buttonAddFrag).setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            transaction.add(R.id.fragmentContainerView, myFragment, FRAGMENT_TAG)

            transaction.commit()
        }

        findViewById<MaterialButton>(R.id.buttonRemoveFrag).setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            transaction.remove(myFragment)

            transaction.commit()
        }

        findViewById<MaterialButton>(R.id.buttonAddFrag2).setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.fragmentContainerView, fragment2)

            transaction.commit()
        }

        (supportFragmentManager.findFragmentByTag(FRAGMENT_TAG) as? MyFragment)?.fragmentFun()

    }

    fun activityFun() {

    }
}