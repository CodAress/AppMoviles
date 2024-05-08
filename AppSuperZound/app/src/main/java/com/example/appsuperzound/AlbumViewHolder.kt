package com.example.appsuperzound

import android.annotation.SuppressLint
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.appsuperzound.AppDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumViewHolder(view: View): RecyclerView.ViewHolder(view){
    val cAlbum = view.findViewById<TextView>(R.id.txtAlbum)
    val cArtist = view.findViewById<TextView>(R.id.txtArtist)
    val cYearRelesed = view.findViewById<TextView>(R.id.txtYearReleased)
    val cScore = view.findViewById<TextView>(R.id.txtScore)
    val cFoto = view.findViewById<ImageView>(R.id.imgAlbumThumb)
    val btnFavorito = view.findViewById<Button>(R.id.btnFavorito)
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

        btnFavorito.setOnClickListener(){
            // Aquí se debería implementar la lógica para agregar o quitar un álbum de la lista de favoritos
            btnFavorito.text = "Marcado como favorito"
            saveAlbumToDatabase(objAlbum)
        }

    }

    private fun saveAlbumToDatabase(album: Album) {
        // Implementa la lógica para guardar el álbum en la base de datos
        // Obtén la instancia de la base de datos
        val database = AppDataBase.getDatabase(itemView.context)

        // Crea una instancia de tableAlbum a partir del objeto Album
        val tableAlbum = tableAlbum(
            idAlbum = album.getAlbumId(),
            strAlbum = album.getAlbum(),
            strArtist = album.getArtist(),
            strAlbumThumb = album.getAlbumThumb(),
            intYearReleased = album.getYearReleased(),
            intScore = album.getScore()
        )

        // Llama al método insert() del DAO
        CoroutineScope(Dispatchers.IO).launch {
            database.albumDAO().insert(tableAlbum)
        }
    }

}