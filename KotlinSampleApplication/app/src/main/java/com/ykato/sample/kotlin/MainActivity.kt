package com.ykato.sample.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.ykato.sample.kotlin.surface.SurfaceViewActivity

class MainActivity : AppCompatActivity() {
    companion object {
        private const val SURFACE_VIEW = "SurfaceView "
        private const val RECYCLER_VIEW = "RecyclerView"
        private const val TEXT_VIEW = "TextView"
        private const val FRAGMENT = "Fragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val funcList = arrayOf(SURFACE_VIEW, RECYCLER_VIEW, TEXT_VIEW, FRAGMENT)

        val listView = findViewById<ListView>(R.id.sampleList)

        val adapter = ArrayAdapter<String>(this,
                R.layout.list_function,
                R.id.function,
                funcList)

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = when (position) {
                0 -> Intent(this, SurfaceViewActivity::class.java)
                1 -> Intent(this, RecyclerViewMainActivity::class.java)
                2 -> Intent(this, TextViewSampleActivity::class.java)
                else -> Intent(this, FragmentSampleActivity::class.java)
            }
            startActivity(intent)
        }
    }
}
