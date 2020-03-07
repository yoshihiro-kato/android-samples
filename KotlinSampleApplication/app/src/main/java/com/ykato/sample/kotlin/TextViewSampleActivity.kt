package com.ykato.sample.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ykato.sample.kotlin.textview.TextViewSampleAdapter
import android.os.AsyncTask

class TextViewSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view_sample)

        val recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.adapter = TextViewSampleAdapter(this)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
    }
}
