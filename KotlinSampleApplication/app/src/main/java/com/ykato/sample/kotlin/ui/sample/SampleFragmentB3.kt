package com.ykato.sample.kotlin.ui.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ykato.sample.kotlin.R

class SampleFragmentB3 : Fragment() {

    companion object {
        fun newInstance() = SampleFragmentB3()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.sample_fragment_b3, container, false)
    }
}