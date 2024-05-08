package com.example.appsuperzound

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class list_albums : AppCompatActivity() {
    lateinit var service:PlaceHolderApi
    lateinit var Lista:List<Album>
    lateinit var adapter:Adapter
    lateinit var  recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_albums)
        recyclerView = findViewById(R.id.recyclerAlbums)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.theaudiodb.com/api/v1/json/523532/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<PlaceHolderApi>(PlaceHolderApi::class.java)

        getAllAlbum()


    }

    // Función para obtener la lista de álbumes
    private fun getAllAlbum(){
        // Inicializar la lista y el adaptador
        Lista = emptyList()
        adapter = Adapter(Lista)

        // Asignar el adaptador al RecyclerView
        recyclerView.adapter = adapter

        service.getAllAlbums().enqueue(object : Callback<AlbumResponse> {
            override fun onResponse(call: Call<AlbumResponse>, response: Response<AlbumResponse>) {
                if(response.isSuccessful){
                    // Imprimir la respuesta sin procesar de la API
                    println("Respuesta de la API: ${response.body()}")
                    // Intentar procesar la respuesta de la API
                    try {
                        Lista = response.body()?.loved ?: emptyList()
                        if(Lista.isEmpty()){
                            println("La lista de álbumes está vacía")
                        }
                        adapter.listaAlbum = Lista
                        adapter.notifyDataSetChanged()
                    } catch (e: Exception) {
                        // Imprimir cualquier error que ocurra al procesar la respuesta
                        println("Error al procesar la respuesta de la API: $e")
                    }
                } else {
                    // Imprimir el código de estado si la respuesta de la API no es exitosa
                    println("La respuesta de la API no fue exitosa. Código de estado: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<AlbumResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}
