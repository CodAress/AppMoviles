package com.example.appsuperzound

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "album_table")
data class tableAlbum(
    @PrimaryKey()
    val idAlbum:Int,
    @ColumnInfo(name = "strAlbum")
    val strAlbum:String,
    @ColumnInfo(name = "strArtist")
    val strArtist:String,
    @ColumnInfo(name = "strAlbumThumb")
    val strAlbumThumb:String,
    @ColumnInfo(name = "intYearReleased")
    val intYearReleased:Int,
    @ColumnInfo(name = "intScore")
    val intScore:Float
)
