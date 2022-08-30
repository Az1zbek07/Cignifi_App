package com.example.cignifiapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences: SharedPreferences = getSharedPreferences("Users", MODE_PRIVATE)
        val email: TextView = findViewById(R.id.textViewEmail)
        val password: TextView = findViewById(R.id.textViewPassword)

        email.text = sharedPreferences.getString("email", "Xato").toString()
        password.text = sharedPreferences.getString("password", "Error").toString()
    }
}