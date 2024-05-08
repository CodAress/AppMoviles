package com.example.appsuperzound

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var service:PlaceHolderApi
    lateinit var Lista:List<Album>
    lateinit var adapter:Adapter
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.theaudiodb.com/api/v1/json/523532/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<PlaceHolderApi>(PlaceHolderApi::class.java)

        val btnListar: Button = findViewById(R.id.btnListAlbums)
        btnListar.setOnClickListener(){
            //getAlbums()
            //creo que se deberia llamar a la actividad que muestra la lista de albums
            val intent = Intent(this, list_albums::class.java)
            startActivity(intent)
        }

        val btnFavoritos: Button = findViewById(R.id.btnFavoriteAlbum)
        btnFavoritos.setOnClickListener(){
            getAlbums()
        }

    }
    private fun getAlbums() {

        val appDB:AppDataBase by lazy { AppDataBase.getDatabase(this) }
        val recyclerView: RecyclerView = findViewById(R.id.recyclerAlbums)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        try {
            runOnUiThread {
                GlobalScope.launch(Dispatchers.IO) {
                    Lista = appDB.albumDAO().getAll()
                    adapter = Adapter(Lista)
                    adapter.notifyDataSetChanged()
                    recyclerView.adapter = adapter
                    /*
                    runOnUiThread {
                        adapter = Adapter(Lista)
                        recyclerView.adapter = adapter
                    }
                    */

                }
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}