package com.example.appsuperzound

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FavoriteAlbumViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val cAlbum = view.findViewById<TextView>(R.id.txtAlbum)
    val cArtist = view.findViewById<TextView>(R.id.txtArtist)
    val cYearRelesed = view.findViewById<TextView>(R.id.txtYearReleased)
    val cScore = view.findViewById<TextView>(R.id.txtScore)
    val cFoto = view.findViewById<ImageView>(R.id.imgAlbumThumb)
    @SuppressLint("SetTextI18n")
    fun render(objAlbum: Album){
        cAlbum.text = "Album: ${objAlbum.getAlbum()}"
        cArtist.text = "Artist: ${objAlbum.getArtist()}"
        cYearRelesed.text = "Year Relesed: ${objAlbum.getYearReleased()}"
        cScore.text = "Score: ${objAlbum.getScore()}"

        Picasso.get().load(objAlbum.strAlbumThumb)
            .resize(250,250)
            .centerCrop()
            .into(cFoto);

    }
}