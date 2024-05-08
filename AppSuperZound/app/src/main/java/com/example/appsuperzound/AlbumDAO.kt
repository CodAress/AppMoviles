package com.example.appsuperzound

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlbumDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tableAlbum: tableAlbum)

    @Query("SELECT * FROM album_table")
    fun getAll(): List<Album>
}