package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.databinding.ItemPhotoBinding

class LucidPhotosAdapter : RecyclerView.Adapter<LucidPhotosAdapter.MyPhotosViewHolder>() {
    private var photos: List<Photos> = mutableListOf()

    class MyPhotosViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Photos) {
            binding.photoId.text = item.id.toString()
            binding.photoName.text = item.title
            binding.photo.load(item.thumbnailUrl)
        }
    }

    fun setData(data: List<Photos>) {
        photos = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPhotosViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = ItemPhotoBinding.inflate(inflator, parent, false)
        return MyPhotosViewHolder(view)
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: MyPhotosViewHolder, position: Int) {
        holder.bind(photos[position])
    }

}