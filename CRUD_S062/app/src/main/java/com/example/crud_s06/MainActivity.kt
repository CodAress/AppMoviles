package com.example.crud_s06

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var service:PlaceHolderApi
    lateinit var photo: Photos
    private lateinit var appDB: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        appDB = AppDatabase.getDatabase(this)

        //Creamos una instancia de retrofit para poder hacer las peticiones a la API
        //En este caso la API es de prueba y se llama jsonplaceholder
        //Definiendo la URL base con el cual se comunicara retrofit
        //addConverterFactory(GsonConverterFactory.create())
        //agrega el convertidor de gson a retrofit para procesar las respuestas JSON del servidor
        // es para que retrofit pueda convertir los datos que recibe a objetos de kotlin
        //build() crea la instancia de retrofit (la construye el cliente de retrofit)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<PlaceHolderApi>(PlaceHolderApi::class.java)//crea una instancia de la interfaz que creamos

        //metodo findviewbyid de la clase AppCompatActivity
        //Este metodo permite buscar elementos especificos dentro del layout que se haya inflado previamente
        //Se le pasa como argumento el identificador único del elemento que se busca en el layout.
        //Este identificador debe corresponder al ID asignado al EditText en el archivo XML del layout (por ejemplo, android:id="@+id/txtConsulta").
        val txtId:EditText = findViewById(R.id.txtConsulta)

        val btnConsultar:Button = findViewById(R.id.btnConsultar)

        //setOnClickListener() es un método que se utiliza para asignar un evento de clic a un botón.
        btnConsultar.setOnClickListener(){
            getPhoto(txtId.text.toString().toInt())
        }

        val btnGrabar:Button = findViewById(R.id.btnGrabar)

        btnGrabar.setOnClickListener(){
            val regPhoto = tablePhoto(
                photo.id,
                photo.albumId,
                photo.title,
                photo.url,
                photo.thumbnailUrl
            )
            GlobalScope.launch {
                appDB.photosDAO().insert(regPhoto)
            }

            val txtRes: TextView = findViewById(R.id.txtRes)
            txtRes.text = "Se registro en BD Local"
        }

        val btnListar:Button = findViewById(R.id.btnListar)

        btnListar.setOnClickListener(){
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun getPhoto(id: Int){
        service.getPhotos(id).enqueue(object:Callback<Photos>{
            override fun onResponse(p0: Call<Photos>, p1: Response<Photos>) {
                photo=p1?.body()!!

                val txtRes: TextView = findViewById(R.id.txtRes)

                txtRes.text =
                            "ALBUM_ID: "+photo?.albumId.toString()+"\n"+
                            "ID: " + photo?.id.toString()+ "\n"+
                            "TITLE: "+photo?.title.toString()+"\n"+
                            "URL: "+photo?.url.toString()+"\n\n"

            }

            override fun onFailure(p0: Call<Photos>, p1: Throwable) {
                p1?.printStackTrace()

            }

        })
    }
}