package com.example.appsuperzound

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(var listaAlbum: List<Album>): RecyclerView.Adapter<AlbumViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AlbumViewHolder(layoutInflater.inflate(R.layout.card_album, parent, false))
    }

    override fun getItemCount(): Int = listaAlbum.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = listaAlbum[position]
        holder.render(item)
    }
}
