package com.example.androiddev.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androiddev.API.PhotosResponse
import com.example.androiddev.R

class PhotosAlbumAdapter(private val list: ArrayList<PhotosResponse>)
    : RecyclerView.Adapter<PhotosAlbumAdapter.MyViewHolder>(){
        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

            val tvText = itemView.findViewById<TextView>(R.id.tvtext_album)
            val imgPhoto = itemView.findViewById<ImageView>(R.id.img_photo_album)

            fun bind(photosResponse: PhotosResponse){
                with(itemView){
                    val text = "Id : ${photosResponse.id} \n" +
                            "Title : ${photosResponse.title}"

                    tvText.text =text
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photos_album, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])

        Glide.with(holder.imgPhoto)
            .load(list?.get(position)?.url)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int = list.size
}