package com.ykato.sample.kotlin.ui.sample

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ykato.sample.kotlin.R

class SampleFragmentC : Fragment() {

    companion object {
        fun newInstance() = SampleFragmentC()
    }

    private lateinit var viewModel: SampleViewModelC

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.sample_fragment_c, container, false)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                    .add(R.id.container, SampleFragmentA.newInstance())
                    .addToBackStack(null)
                    .commit()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SampleViewModelC::class.java)
        // TODO: Use the ViewModel
    }

}