package com.example.crud_s06

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_table")
data class tablePhoto(
    @PrimaryKey()
    val id: Int,
    @ColumnInfo(name = "album_id")
    val albumId: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "thumbnail_url")
    val thumbnailUrl: String
)
