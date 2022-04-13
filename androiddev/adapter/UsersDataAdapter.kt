package com.example.androiddev.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddev.API.UsersResponseItem
import com.example.androiddev.R

class UsersDataAdapter(val data : List<UsersResponseItem?>) : RecyclerView.Adapter<UsersDataAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val tvId = itemView.findViewById<TextView>(R.id.tv_idData)
        val tvNama = itemView.findViewById<TextView>(R.id.tv_namaData)
        val tvEmail = itemView.findViewById<TextView>(R.id.tv_emailData)
        val tvNotelp = itemView.findViewById<TextView>(R.id.tv_notelpData)
        val tvAlamat = itemView.findViewById<TextView>(R.id.tv_alamatData)
        val tvCompany = itemView.findViewById<TextView>(R.id.tv_companyData)

        fun bind(usersResponse: UsersResponseItem?){
            with(itemView){
                val id = "Id : ${usersResponse?.id}"
                val nama = "Nama : ${usersResponse?.name}"
                val email = "Email : ${usersResponse?.email}"
                val noTelp = "NoTelp : ${usersResponse?.phone}"
                val address = "Alamat : \n" +
                        "${usersResponse?.address?.street}, " +
                        "${usersResponse?.address?.city}, " +
                        "${usersResponse?.address?.suite}, " +
                        "${usersResponse?.address?.zipcode} \n" +
                        "Lng : ${usersResponse?.address?.geo?.lng}, " +
                        "Lat : ${usersResponse?.address?.geo?.lat}"
                val company = "Company : \n" +
                        "${usersResponse?.company?.bs}, " +
                        "${usersResponse?.company?.catchPhrase}, " +
                        "${usersResponse?.company?.name}"

                tvId.text = id
                tvNama.text = nama
                tvEmail.text = email
                tvNotelp.text = noTelp
                tvAlamat.text = address
                tvCompany.text = company
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_users_data, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    override fun getItemCount(): Int = data?.size ?: 0
}