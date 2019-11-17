package com.example.myapplication.ui.griffindor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class GriffindorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_griffindor, container, false)

    companion object {
        fun newInstance(): GriffindorFragment = GriffindorFragment()
    }
}
