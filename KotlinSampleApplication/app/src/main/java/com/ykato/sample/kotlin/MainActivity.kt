package com.ykato.sample.kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.commit
import com.ykato.sample.kotlin.datastore.MemoFragment
import com.ykato.sample.kotlin.surface.SurfaceViewActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KClass

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        private const val SURFACE_VIEW = "SurfaceView "
        private const val RECYCLER_VIEW = "RecyclerView"
        private const val TEXT_VIEW = "TextView"
        private const val FRAGMENT = "Fragment"
        private const val DATA_STORE = "DataStore"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val funcList = arrayOf(SURFACE_VIEW, RECYCLER_VIEW, TEXT_VIEW, FRAGMENT, DATA_STORE)

        val listView = findViewById<ListView>(R.id.sampleList)

        val adapter = ArrayAdapter<String>(this,
                R.layout.list_function,
                R.id.function,
                funcList)

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> launchActivity(SurfaceViewActivity::class)
                1 -> launchActivity(RecyclerViewMainActivity::class)
                2 -> launchActivity(TextViewSampleActivity::class)
                3 -> launchActivity(FragmentSampleActivity::class)
                else -> {
                    val fragment = MemoFragment.newInstance()
                    supportFragmentManager.commit {
                        add(R.id.main, fragment)
                        addToBackStack(null)
                    }
                }
            }
        }
    }

    private fun <T : Activity> launchActivity(cls: KClass<T>) =
            startActivity(Intent(this, cls.java))
}
