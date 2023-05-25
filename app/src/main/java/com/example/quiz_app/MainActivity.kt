package com.example.quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = StartFragment()
        val container = findViewById<FragmentContainerView>(R.id.container)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .commit()
    }
}