package com.example.ampa_lab_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.textView2)
        val startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    val intent = result.data
                    val i = intent?.getIntExtra("result", 0)
                    if (i != null) {
                        val str = i.toString()
                        tv.text = str
                    }
                }
            }

        val bnNavView = findViewById<View>(R.id.bottom_nav) as BottomNavigationView
        bnNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bn_left -> startActivity(
                    Intent(this, ActivityLeft::class.java))
                R.id.bn_center -> {
                    val bundle = Bundle()
                    bundle.putInt("progress", tv.getText().toString().toInt())
                    val intent = Intent(this, ActivityCenter::class.java)
                    intent.putExtras(bundle)
                    startForResult.launch(intent)
                }
                R.id.bn_right -> startActivity(
                    Intent(this, ActivityRight::class.java))
            }
            true
        }
    }
}