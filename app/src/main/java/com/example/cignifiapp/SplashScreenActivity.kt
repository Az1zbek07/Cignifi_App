package com.example.cignifiapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        sharedPreferences = getSharedPreferences("Users", MODE_PRIVATE)
        countDownTimer()
    }
    private fun countDownTimer(){
        object : CountDownTimer(3000, 1000){
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                if (sharedPreferences.getString("email", "").toString() == ""){
                    startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
                } else{
                    startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                }
                finish()
            }
        }.start()
    }
}