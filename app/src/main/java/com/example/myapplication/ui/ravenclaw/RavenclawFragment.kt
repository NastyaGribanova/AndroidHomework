package com.example.myapplication.ui.ravenclaw

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class RavenclawFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_ravenclaw, container, false)

    companion object {
        fun newInstance(): RavenclawFragment = RavenclawFragment()
    }
}
