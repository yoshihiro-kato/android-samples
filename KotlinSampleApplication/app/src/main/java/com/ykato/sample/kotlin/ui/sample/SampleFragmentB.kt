package com.ykato.sample.kotlin.ui.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.ykato.sample.kotlin.R

class SampleFragmentB : Fragment() {

    companion object {
        fun newInstance() = SampleFragmentB()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        println("${this.javaClass.simpleName} onCreateView")
        val view = inflater.inflate(R.layout.sample_fragment_b, container, false)
        view.findViewById<Button>(R.id.button).setOnClickListener {
//            requireActivity().supportFragmentManager.beginTransaction()
//                    .add(R.id.container, SampleFragmentC.newInstance())
//                    .addToBackStack(null)
//                    .commit()
//            view.findNavController().navigate(R.id.action_sampleFragmentB_to_sampleFragmentC)
            view.findNavController().navigate(R.id.action_sampleFragmentB_to_sampleFragmentB2)
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        println("${this.javaClass.simpleName} onDestroy")
    }
}