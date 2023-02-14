package com.example.ampa_lab_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityRight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_right)

        val tv1 = findViewById<TextView>(R.id.textView)
        val startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    val intent = result.data
                    val i = intent?.getIntExtra("result", 0)
                    if (i != null) {
                        val str = i.toString()
                        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
                        tv1.setText(str)
                    }
                }
            }

        val buttonCalc = findViewById<Button>(R.id.button)
        val et1 = findViewById<EditText>(R.id.editTextTextPersonName)
        val et2 = findViewById<EditText>(R.id.editTextTextPersonName2)

        buttonCalc.setOnClickListener { _ ->
            val val1: Int = et1.text.toString().toInt()
            val val2: Int = et2.text.toString().toInt()
            val bundle = Bundle()
            bundle.putInt("val1", val1)
            bundle.putInt("val2", val2)
            val intent = Intent(this, ActivityCalc::class.java)
            intent.putExtras(bundle)
            startForResult.launch(intent)

        }
    }
}