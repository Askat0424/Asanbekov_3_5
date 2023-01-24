package com.example.asanbekov_3_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.asanbekov_3_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            if(savedInstanceState == null)
                supportFragmentManager.beginTransaction()
                    .add(R.id.container, PlusMinusFragment()).commit()
        }
    }
