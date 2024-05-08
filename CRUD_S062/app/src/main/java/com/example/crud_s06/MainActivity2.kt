package com.example.crud_s06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    lateinit var Lista:List<tablePhoto>
    lateinit var adapter:Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)


        val appDB:AppDatabase by lazy { AppDatabase.getDatabase(this) }
        val recyclerView: RecyclerView = findViewById(R.id.recyclerPhotos)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        try {
            runOnUiThread {
                GlobalScope.launch(Dispatchers.IO) {
                    Lista = appDB.photosDAO().getAll()
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