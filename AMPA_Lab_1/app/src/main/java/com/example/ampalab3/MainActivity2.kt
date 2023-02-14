package com.example.ampalab3

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val rb1: RadioButton = findViewById(R.id.radioButton1)
        val rb2: RadioButton = findViewById(R.id.radioButton2)
        val text1: TextView = findViewById(R.id.textView1)
        val tb1: ToggleButton = findViewById(R.id.toggleButton1)
        val iv1: ImageView = findViewById(R.id.imageView1)
        val b5: Button = findViewById(R.id.button5)
        val b4: Button = findViewById(R.id.button4)
        rb1.setOnClickListener {
            text1.setText(R.string.text1)
        }
        rb2.setOnClickListener {
            text1.setText(R.string.text2)
        }
        tb1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                iv1.visibility = View.INVISIBLE
            }
            else {
                iv1.visibility = View.VISIBLE
            }
        }
        b4.setOnClickListener {
            Toast.makeText(applicationContext, "Text: " + text1.text,
                Toast.LENGTH_SHORT).show();
        }
        b5.setOnClickListener {
            finish()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}