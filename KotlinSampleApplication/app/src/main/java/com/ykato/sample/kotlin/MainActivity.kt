package com.ykato.sample.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.ykato.sample.kotlin.surface.SurfaceViewActivity

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val funcList = arrayOf("surfaceView", "recyclerView", "textview")

        val listView = findViewById<ListView>(R.id.sampleList)

        val adapter = ArrayAdapter<String>(this,
                R.layout.list_function,
                R.id.function,
                funcList)

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = when (position) {
                0 -> Intent(this, SurfaceViewActivity::class.java)
                1 -> Intent(this, RecyclerViewMainActivity::class.java)
                else -> Intent(this, TextViewSampleActivity::class.java)
            }
            startActivity(intent)
        }
    }
}
