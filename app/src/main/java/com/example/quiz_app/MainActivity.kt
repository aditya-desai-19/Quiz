package com.example.quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = StartFragment()
        val fragmentManager = supportFragmentManager
        val trans = fragmentManager.beginTransaction()
        trans.add(R.id.container, fragment)
        trans.commit()
    }

}