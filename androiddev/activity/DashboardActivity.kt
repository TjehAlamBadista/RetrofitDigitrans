package com.example.androiddev.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.androiddev.R
import com.example.androiddev.helper.PrefManager

class DashboardActivity : AppCompatActivity() {

    private lateinit var prefManager: PrefManager

    private lateinit var btnLogout : Button
    private lateinit var cvAlbum : CardView
    private lateinit var cvAlbumData : CardView
    private lateinit var cvUsers : CardView
    private lateinit var cvUsersData : CardView

    private lateinit var email : String
    private lateinit var tvData : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        init()
        checkLogin()
        setupUI()

        btnLogout.setOnClickListener {
            clickLogout()
        }

        cvAlbum.setOnClickListener {
            val intent = Intent(this, ImageGalleryActivity::class.java)
            startActivity(intent)
        }

        cvAlbumData.setOnClickListener {
            val intent = Intent(this, PhotosActivity::class.java)
            startActivity(intent)
        }

        cvUsers.setOnClickListener {
            val intent = Intent(this, UsersActivity::class.java)
            startActivity(intent)
        }

        cvUsersData.setOnClickListener {
            val intent = Intent(this, UsersDataActivity::class.java)
            startActivity(intent)
        }
    }

    private fun init() {
        prefManager = PrefManager(this)

        btnLogout = findViewById(R.id.btn_logout)

        cvAlbum = findViewById(R.id.cv_album_gallery)
        cvUsers = findViewById(R.id.cv_users)
        cvAlbumData = findViewById(R.id.cv_album_photos)
        cvUsersData = findViewById(R.id.cv_users_data)

        email = prefManager.getEmail().toString()
        tvData = findViewById(R.id.tv_data)
    }

    private fun setupUI() {
        if (prefManager.isLogin() == false){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun checkLogin() {
        tvData.text = "Selamat Datang"
    }

    fun clickLogout(){
        prefManager.removeData()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}