package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_tricks.*

class TricksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_tricks, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_name.text = arguments?.getString(ARG_NAME)
        tv_curse.text = arguments?.getString(ARG_CURSE)
        tv_thing.text = arguments?.getString(ARG_THING)
    }

    companion object {

        private const val ARG_NAME = "name"
        private const val ARG_CURSE = "curse"
        private const val ARG_THING = "thing"

        fun newInstance(name: String = "NULL", curse: String = "NULL", thing: String = "NULL"):
                TricksFragment = TricksFragment().apply {
                      arguments = Bundle().apply {
                        putString(ARG_NAME, name)
                        putString(ARG_CURSE, curse)
                        putString(ARG_THING, thing)
                    }
                }
    }
}
