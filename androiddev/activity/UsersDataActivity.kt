package com.example.androiddev.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddev.API.UsersResponseItem
import com.example.androiddev.R
import com.example.androiddev.adapter.UsersAdapter
import com.example.androiddev.adapter.UsersDataAdapter
import com.example.retrofit3.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersDataActivity : AppCompatActivity() {

    private var list = ArrayList<UsersResponseItem>()

    private lateinit var rvUsers : RecyclerView
    private lateinit var tvResponse : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_data)

        rvUsers = findViewById(R.id.rv_usersData)
        tvResponse = findViewById(R.id.tv_responseData)

        rvUsers.setHasFixedSize(true)
        rvUsers.layoutManager = LinearLayoutManager(this)

        ApiConfig.getService().getUsers().enqueue(object : Callback<List<UsersResponseItem>> {
            override fun onResponse(
                call: Call<List<UsersResponseItem>>,
                response: Response<List<UsersResponseItem>>,
            ) {
                val responseCode = response.code().toString()
                tvResponse.text = responseCode

                response.body()?.let { list.addAll(it) }
                val adapter = UsersDataAdapter(list)
                rvUsers.adapter = adapter
            }

            override fun onFailure(call: Call<List<UsersResponseItem>>, t: Throwable) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}