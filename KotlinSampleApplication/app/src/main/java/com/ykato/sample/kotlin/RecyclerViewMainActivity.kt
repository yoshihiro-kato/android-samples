package com.ykato.sample.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ykato.sample.kotlin.recyclerview.DateAdapter

class RecyclerViewMainActivity : AppCompatActivity() {
    private val SPAN_COUNT = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.calendar)
        val adapter = DateAdapter(this)
        recyclerView.adapter = adapter
        val layoutManager = androidx.recyclerview.widget.GridLayoutManager(this, SPAN_COUNT)
        recyclerView.layoutManager = layoutManager
    }
}
