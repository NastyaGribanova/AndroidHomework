package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dirty_tricks.*
import kotlinx.android.synthetic.main.fragment_dirty_tricks.view.*


class DirtyTricksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_dirty_tricks, container, false)
        view.button_trick.setOnClickListener {
            val name: String = et_firstTrick.text.toString()
            val curse: String = et_secondTrick.text.toString()
            val thing: String = et_thirdTrick.text.toString()
            nextFragment(name, curse, thing)
        }
        return view
    }

    private fun nextFragment(name: String, curse: String, thing: String){
        fragmentManager.also {
            it?.beginTransaction()?.apply {
                setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
                replace(R.id.nav_host_fragment, TricksFragment.newInstance(name, curse, thing))
                fragmentManager?.popBackStack()
                addToBackStack(TricksFragment::class.java.name)
                commit()
            }
        }
    }

    companion object {
        fun create(): DirtyTricksFragment = DirtyTricksFragment()
    }
}
