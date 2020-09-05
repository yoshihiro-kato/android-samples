package com.ykato.sample.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ykato.sample.kotlin.textview.TextViewSampleAdapter
import android.os.AsyncTask

class TextViewSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view_sample)

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.list)
        recyclerView.adapter = TextViewSampleAdapter(this)
        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(androidx.recyclerview.widget.DividerItemDecoration(this, layoutManager.orientation))
    }
}
