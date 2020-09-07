package com.ykato.sample.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ykato.sample.kotlin.ui.sample.SampleFragmentA

class FragmentSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_sample_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SampleFragmentA.newInstance())
                    .commitNow()
        }
    }
}