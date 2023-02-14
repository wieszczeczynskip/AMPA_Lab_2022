package com.example.ampa_lab_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityCenter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_center)

        val iii: Intent = intent
        val bundle = iii.extras
        val sb = findViewById<SeekBar>(R.id.seekBar)
        val tv = findViewById<TextView>(R.id.textView4)
        if (bundle != null) {
            sb.progress = bundle.getInt("progress", 0)
            tv.text = bundle.getInt("progress", 0).toString()
        }

        sb.setOnSeekBarChangeListener(object: OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar, progress: Int, fromUser: Boolean) {
                tv.text = sb.progress.toString()
            }

            override fun onStartTrackingTouch(sb: SeekBar) {
            }

            override fun onStopTrackingTouch(sb: SeekBar) {
                val res = sb.progress
                iii.putExtra("result", res)
                setResult(RESULT_OK, iii)
                finish()
            }
        })
    }
}