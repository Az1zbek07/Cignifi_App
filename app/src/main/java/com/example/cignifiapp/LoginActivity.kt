package com.example.cignifiapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cignifiapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("Users", MODE_PRIVATE)
        initViews()
    }
    private fun initViews(){
        signIn()
        signUp()
    }

    private fun signIn(){
        var check = true
        binding.btnSignIn.setOnClickListener {
            var email = ""
            var password = ""

            if (binding.LoginEmail.text.isEmpty()){
                Toast.makeText(this, "Please enter your email correctly", Toast.LENGTH_SHORT).show()
                check = false
            } else{
                email = binding.LoginEmail.text.toString().trim()
                check = true
            }

            if (binding.LoginPassword.text.isEmpty()){
                Toast.makeText(this, "Please enter your password correctly", Toast.LENGTH_SHORT).show()
                check = false
            } else{
                password = binding.LoginPassword.text.toString().trim()
                check = true
            }

            if (check){
                val emailOld = sharedPreferences.getString("email", "")
                val passwordOld = sharedPreferences.getString("password", "")

                if (emailOld == email && password == passwordOld){
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }else {
                    Toast.makeText(this, "Your Account is not founded", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun signUp(){
        binding.textSignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}