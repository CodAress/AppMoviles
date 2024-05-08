package com.example.crud_s06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val listaPhotos: List<tablePhoto>):RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PhotoViewHolder(layoutInflater.inflate(R.layout.card, parent, false))
    }

    override fun getItemCount(): Int = listaPhotos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = listaPhotos[position]
        holder.render(item)
    }
}