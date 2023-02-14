package com.example.ampa_lab_22

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bt = findViewById<Button>(R.id.button)
        bt.setOnClickListener {
            val intencja = Intent()
            intencja.component = ComponentName(
                "com.example.ampa_lab_2",
                "com.example.ampa_lab_2.MainActivity"
            )
            startActivity(intencja)

        }
    }
}