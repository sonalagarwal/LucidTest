package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemPhotoBinding

class LucidPhotosAdapter(private val data : List<Photos>) : RecyclerView.Adapter<LucidPhotosAdapter.MyPhotosViewHolder>(){

    class MyPhotosViewHolder(private val binding: ItemPhotoBinding)  : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Photos) {
            binding.photoId.text = item.id.toString()
            binding.photoName.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPhotosViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = ItemPhotoBinding.inflate(inflator, parent, false)
        return MyPhotosViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyPhotosViewHolder, position: Int) {
        holder.bind(data[position])
    }

}