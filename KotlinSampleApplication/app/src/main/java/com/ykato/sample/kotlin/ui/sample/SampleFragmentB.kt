package com.ykato.sample.kotlin.ui.sample

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ykato.sample.kotlin.R

class SampleFragmentB : Fragment() {

    companion object {
        fun newInstance() = SampleFragmentB()
    }

    private lateinit var viewModel: SampleViewModelB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.sample_fragment_b, container, false)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                    .add(R.id.container, SampleFragmentC.newInstance())
                    .addToBackStack(null)
                    .commit()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SampleViewModelB::class.java)
        // TODO: Use the ViewModel
    }

}