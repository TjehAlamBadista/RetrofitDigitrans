package com.example.androiddev

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androiddev.activity.LoginActivity
import com.example.androiddev.databinding.ActivityMainBinding
import com.example.androiddev.helper.PrefManager

class MainActivity : AppCompatActivity() {

    private lateinit var prefManager: PrefManager

    private lateinit var binding : ActivityMainBinding
    private var MY_SHARED_PREF_EMAIL = "my_shared_pref"

    var EMAIL = "email"
    var PASSWORD = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefManager = PrefManager(this)

        loadData()

        binding.btnRegister.setOnClickListener {
            saveData()
        }

        binding.tvLogin.setOnClickListener {
            val intent =Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadData() {

    }

    private fun saveData() {
        val insertEmail = binding.etEmail.text.toString()
        val insertPassword = binding.etPassword.text.toString()

        val sharedPref = getSharedPreferences(
            MY_SHARED_PREF_EMAIL,
            Context.MODE_PRIVATE
        )

        val editor = sharedPref.edit()
        editor.putString(EMAIL, insertEmail)
        editor.putString(PASSWORD, insertPassword)

        Toast.makeText(
            this, "Data Saved",
            Toast.LENGTH_SHORT
        ).show()
    }
}