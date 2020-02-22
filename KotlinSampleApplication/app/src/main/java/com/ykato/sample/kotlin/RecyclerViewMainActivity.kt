package com.ykato.sample.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.ykato.sample.kotlin.recyclerview.DateAdapter

class RecyclerViewMainActivity : AppCompatActivity() {
    private val SPAN_COUNT = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView = findViewById<RecyclerView>(R.id.calendar)
        val adapter = DateAdapter(this)
        recyclerView.adapter = adapter
        val layoutManager = GridLayoutManager(this, SPAN_COUNT)
        recyclerView.layoutManager = layoutManager
    }
}
