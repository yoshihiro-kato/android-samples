package com.ykato.sample.kotlin

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.ykato.sample.kotlin.ui.sample.SampleFragmentA

class FragmentSampleActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_sample_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, SampleFragmentA.newInstance())
                    .commitNow()
        }
    }
}