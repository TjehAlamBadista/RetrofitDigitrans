package com.example.androiddev.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.androiddev.MainActivity
import com.example.androiddev.R
import com.example.androiddev.helper.PrefManager

class LoginActivity : AppCompatActivity() {

    private lateinit var prefManager: PrefManager

    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLogin : Button
    private lateinit var tvRegister : TextView

    private lateinit var email : String
    private lateinit var password : String

    private var validEmail = "badista@gmail.com"
    private var validPassword = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
        checkLogin()

        btnLogin.setOnClickListener {
            clickLogin()
        }

        tvRegister.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun init() {
        prefManager = PrefManager(this)

        btnLogin = findViewById(R.id.btn_login)
        tvRegister = findViewById(R.id.tv_register)

        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
    }

    private fun checkLogin() {
        if (prefManager.isLogin()!!){
            val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun clickLogin(){
        email = etEmail.text.toString().trim()
        password = etPassword.text.toString().trim()
        if (email.isEmpty() || email == ""){

        }
        else if(password.isEmpty() || password == "") {
            etPassword.error = "Wajib Diisi !"
            etPassword.requestFocus()
        }
        else if(email != validEmail){
            etEmail.error = "Email Salah !"
            etEmail.requestFocus()
        }
        else if(password != validPassword){
            etPassword.error = "Password Salah !"
            etPassword.requestFocus()
        }
        else{
            prefManager.setLogin(true)
            prefManager.setEmail(email)

            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}