package com.example.ampalab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener { view ->
            val myIntent = Intent(this, MainActivity2::class.java)
            startActivity(myIntent)
        }
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener { view ->
            val myIntent = Intent(this, MainActivity3::class.java)
            startActivity(myIntent)
        }
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener { view ->
            val myIntent = Intent(this, MainActivity4::class.java)
            startActivity(myIntent)
        }
    }
}