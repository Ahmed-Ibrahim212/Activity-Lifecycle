package com.example.mytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceControl
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*
//al myFragment = ExampleFragment()v

class MainActivity2 : AppCompatActivity() {
    private var counter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val FirstFragment = FirstFragment()
        val SecondFragment = SecondFragment()

//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.container, FirstFragment)
//            commit()
//        }
        button.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.button, FirstFragment)
                addToBackStack(null)
                commit()
            }
        }
        button3.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.button3, SecondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}
