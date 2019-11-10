package com.example.myapplication.ui.slytherin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.DirtyTricksFragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_slytherin.view.*

class SlytherinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_slytherin, container, false)
        view.button_tricks?.setOnClickListener {
            nextFragment()
        }
        return view
    }

    private fun nextFragment(){
        fragmentManager.also {
            it?.beginTransaction()?.apply {
                setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_left)
                replace(R.id.nav_host_fragment, DirtyTricksFragment.create())
                fragmentManager?.popBackStack()
                addToBackStack(DirtyTricksFragment::class.java.name)
                commit()
            }
        }
    }

}
