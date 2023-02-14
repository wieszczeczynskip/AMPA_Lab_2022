package com.example.ampa_lab_2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityLeft : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_left)

        fun runDial(phoneNum: String) {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNum")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        fun runBrowser(browser: String) {
            val uri = Uri.parse(browser)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        fun runMaps(location: String) {
            val gmmIntentUri = Uri.parse("geo:0,0?q=$location")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        fun runSMS(message: String) {
            val uri = Uri.parse("sms:")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.putExtra("sms_body", message)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        val bnDial = findViewById<Button>(R.id.button3)
        val etPhone = findViewById<EditText>(R.id.editTextPhone)
        bnDial.setOnClickListener {
            runDial(etPhone.text.toString())
        }

        val etBrowser = findViewById<EditText>(R.id.editTextTextPersonName3)
        val bnBrowser = findViewById<Button>(R.id.button4)
        bnBrowser.setOnClickListener {
            runBrowser(etBrowser.text.toString())
        }

        val etMaps = findViewById<EditText>(R.id.editTextTextPersonName4)
        val bnMaps = findViewById<Button>(R.id.button5)
        bnMaps.setOnClickListener {
            runMaps(etMaps.text.toString())
        }

        val etSMS = findViewById<EditText>(R.id.editTextTextPersonName5)
        val bnSMS = findViewById<Button>(R.id.button6)
        bnSMS.setOnClickListener {
            runSMS(etSMS.text.toString())
        }
    }
}