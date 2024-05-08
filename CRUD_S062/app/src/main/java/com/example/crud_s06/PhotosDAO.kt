package com.example.crud_s06

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhotosDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tablePhoto: tablePhoto)

    @Query("SELECT * FROM photo_table")
    fun getAll(): List<tablePhoto>

}