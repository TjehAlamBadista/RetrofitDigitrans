package com.example.androiddev.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddev.API.PhotosResponse
import com.example.androiddev.API.RetrofitClient
import com.example.androiddev.R
import com.example.androiddev.adapter.PhotosAlbumAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosActivity : AppCompatActivity() {

    private val list = ArrayList<PhotosResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        val rvPost = findViewById<RecyclerView>(R.id.rvResponse_album)
        val tvResponse = findViewById<TextView>(R.id.tvResponse_album)

        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getPhotos().enqueue(object : Callback<ArrayList<PhotosResponse>> {
            override fun onResponse(
                call: Call<ArrayList<PhotosResponse>>,
                response: Response<ArrayList<PhotosResponse>>,
            ) {
                val responseCode = response.code().toString()
                tvResponse.text = responseCode
                response.body()?.let { list.addAll(it) }
                val adapter = PhotosAlbumAdapter(list)
                rvPost.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<PhotosResponse>>, t: Throwable) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}