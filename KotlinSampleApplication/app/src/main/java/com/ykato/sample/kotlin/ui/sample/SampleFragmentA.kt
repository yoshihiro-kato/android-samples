package com.ykato.sample.kotlin.ui.sample

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ykato.sample.kotlin.R
import kotlinx.android.synthetic.main.sample_fragment.*

class SampleFragmentA : Fragment() {

    companion object {
        fun newInstance() = SampleFragmentA()
    }

    private lateinit var viewModel: SampleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.sample_fragment, container, false)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                    .add(R.id.container, SampleFragmentB.newInstance())
                    .addToBackStack(null)
                    .commit()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SampleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}