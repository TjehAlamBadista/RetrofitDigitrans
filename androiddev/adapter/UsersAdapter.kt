package com.example.androiddev.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddev.API.UsersResponseItem
import com.example.androiddev.R

class UsersAdapter(val data : List<UsersResponseItem?>) : RecyclerView.Adapter<UsersAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val tvNama = itemView.findViewById<TextView>(R.id.tv_nama)
        val tvEmail = itemView.findViewById<TextView>(R.id.tv_email)

        fun bind(usersResponse: UsersResponseItem?){
            with(itemView){
                val nama = "Nama : ${usersResponse?.name}"
                val email = "Email : ${usersResponse?.email}"

                tvNama.text = nama
                tvEmail.text = email
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    override fun getItemCount(): Int = data?.size ?: 0
}