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
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_tricks, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name: String = arguments?.getString("name").toString()
        val curse: String = arguments?.getString("curse").toString()
        val thing: String = arguments?.getString("thing").toString()
        tv_name.text = name
        tv_curse.text = curse
        tv_thing.text = thing
    }

    companion object {

        private const val NAME = "name"
        private const val CURSE = "curse"
        private const val THING = "thing"

        fun newInstance(name: String = "NULL", curse: String = "NULL", thing: String = "NULL"):
                TricksFragment = TricksFragment().apply {
                    arguments = Bundle().apply {
                        putString(NAME, name)
                        putString(CURSE, curse)
                        putString(THING, thing)
                    }
                }
    }
}
