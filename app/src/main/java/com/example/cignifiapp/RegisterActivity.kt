package com.example.cignifiapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cignifiapp.databinding.ActivityLoginBinding
import com.example.cignifiapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("Users", MODE_PRIVATE)

        initViews()
    }

    private fun initViews(){
        back()
        signUp()
    }

    private fun back(){
        binding.imgBackArrow.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
    private fun signUp(){
        val edit = sharedPreferences.edit()

        binding.btnSignIn.setOnClickListener {
            var check = false
            var email = ""
            var password = ""

            if (binding.RegisterEmail.text.isEmpty()){
                Toast.makeText(this, "Please enter your email correctly", Toast.LENGTH_SHORT).show()
                check = false
            } else{
                email = binding.RegisterEmail.text.toString().trim()
                check = true
            }

            if (binding.RegisterPassword.text.isEmpty()){
                Toast.makeText(this, "Please enter your password correctly", Toast.LENGTH_SHORT).show()
                check = false
            } else{
                password = binding.RegisterPassword.text.toString().trim()
                check = true
            }

            if (binding.confirmPassword.text.isEmpty() || binding.confirmPassword.text.toString() != password){
                Toast.makeText(this, "Please enter your password again", Toast.LENGTH_SHORT).show()
                check = false
            } else{
                check = true
            }

            if (check == true){
                edit.putString("email", email)
                edit.putString("password", password)
                edit.apply()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}