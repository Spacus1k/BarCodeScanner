package ru.shpak.barcodescanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actimity_main)

        val numbersList: RecyclerView = findViewById(R.id.numbers)
        val linearLayoutManager = LinearLayoutManager(this)
        numbersList.layoutManager = linearLayoutManager
        numbersList.setHasFixedSize(true)

        val numberAdapter = NumberAdapter(100)
        numbersList.adapter = numberAdapter
    }
}