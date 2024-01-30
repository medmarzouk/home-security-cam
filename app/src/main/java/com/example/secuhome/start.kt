package com.example.secuhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secuhome.databinding.ActivityMainBinding
import com.example.secuhome.databinding.ActivityStartBinding

class start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener{
            val i1 = Intent(this,About::class.java)
            startActivity(i1)
        }
        binding.button.setOnClickListener{
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }


    }
}