package com.ykato.sample.kotlin.ui.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.ykato.sample.kotlin.R

class SampleFragmentB2 : Fragment() {

    companion object {
        fun newInstance() = SampleFragmentB2()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.sample_fragment_b2, container, false)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            view.findNavController().navigate(R.id.action_sampleFragmentB2_to_sampleFragmentB3)
        }
        return view
    }
}