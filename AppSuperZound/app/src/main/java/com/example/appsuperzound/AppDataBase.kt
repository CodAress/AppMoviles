package com.example.appsuperzound

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [tableAlbum::class], version = 1)
abstract class AppDataBase: RoomDatabase(){
    abstract fun albumDAO(): AlbumDAO

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "album_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}