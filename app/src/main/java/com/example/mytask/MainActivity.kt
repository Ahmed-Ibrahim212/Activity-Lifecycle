package com.example.mytask

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var landScapeCount = 1

    private lateinit var lifecycleText: TextView
    private lateinit var button2: Button
    private lateinit var textViewDisplayTextChange: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button2 = findViewById(R.id.button2)

        lifecycleText = findViewById(R.id.lifecycle_state)
        textViewDisplayTextChange = findViewById(R.id.next)
        lifecycleText.text = "On Create State"


        // moving to the next screen task
        button2.setOnClickListener {
           val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", landScapeCount)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        var counter = savedInstanceState.getInt("count", 0)
        landScapeCount = counter
        val orientationChangeCount = resources.configuration.orientation
        if (orientationChangeCount == Configuration.ORIENTATION_LANDSCAPE) {
            ++landScapeCount
            findViewById<TextView>(R.id.next).text=landScapeCount.toString()+"Landscape Mode"
        } else {
            ++landScapeCount
            findViewById<TextView>(R.id.next).text=landScapeCount.toString()+"Portrait Mode"
        }
    }
}

