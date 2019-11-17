package com.example.myapplication.ui.slytherin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.DirtyTricksFragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_slytherin.*

class SlytherinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  = inflater.inflate(R.layout.fragment_slytherin, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_tricks.setOnClickListener {
            fragmentManager.also {
                it?.beginTransaction()?.apply {
                    setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_left)
                    replace(R.id.frameLayout, DirtyTricksFragment.create())
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }

    companion object {
        fun newInstance(): SlytherinFragment = SlytherinFragment()
    }
}
