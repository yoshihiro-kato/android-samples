package com.ykato.sample.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ykato.sample.kotlin.recyclerview.DateAdapter
import com.ykato.sample.kotlin.recyclerview.DateItemDecoration

class RecyclerViewMainActivity : AppCompatActivity() {
    companion object {
        private const val SPAN_COUNT = 7
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView = findViewById<RecyclerView>(R.id.calendar)
        val adapter = DateAdapter(this)
        recyclerView.adapter = adapter
        val layoutManager = GridLayoutManager(this, SPAN_COUNT)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DateItemDecoration())
    }
}
