package com.example.ampalab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val b6: Button = findViewById(R.id.button6)
        val b7: Button = findViewById(R.id.button7)
        val mailf: EditText = findViewById(R.id.mailf)
        b6.setOnClickListener {
            Toast.makeText(applicationContext, "E-mail: " + mailf.text,
                Toast.LENGTH_SHORT).show();
        }
        b7.setOnClickListener {
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