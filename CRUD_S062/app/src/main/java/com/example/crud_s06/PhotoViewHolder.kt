package com.example.crud_s06

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhotoViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val cid = view.findViewById<TextView>(R.id.txtCardId)
    val calbumId= view.findViewById<TextView>(R.id.txtCardAlbumId)
    val ctitle = view.findViewById<TextView>(R.id.txtTile)
    val curl = view.findViewById<TextView>(R.id.txtUrl)
    val cthumbnailUrl = view.findViewById<TextView>(R.id.txtThumbnailUrl)

    fun render(objPhoto: tablePhoto){
        cid.text = objPhoto.id.toString()
        calbumId.text = objPhoto.albumId.toString()
        ctitle.text = objPhoto.title.toString()
        curl.text = objPhoto.url.toString()
        cthumbnailUrl.text = objPhoto.thumbnailUrl.toString()
    }
}