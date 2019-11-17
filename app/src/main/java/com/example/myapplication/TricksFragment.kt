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
        tv_name.text = arguments?.getString(NAME)
        tv_curse.text = arguments?.getString(CURSE)
        tv_thing.text = arguments?.getString(THING)
    }

    companion object {

        private const val NAME = "name"
        private const val CURSE = "curse"
        private const val THING = "thing"

        fun newInstance(name: String = "NULL", curse: String = "NULL", thing: String = "NULL"):
                TricksFragment = TricksFragment().also {
                    it.arguments = Bundle().apply {
                        putString(NAME, name)
                        putString(CURSE, curse)
                        putString(THING, thing)
                    }
                }
    }
}
