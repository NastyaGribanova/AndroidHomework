package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dirty_tricks.*

class DirtyTricksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_dirty_tricks, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_trick.setOnClickListener {}
        fragmentManager.also {
            it?.beginTransaction()?.apply {
                val name: String = et_firstTrick.text.toString()
                val curse: String = et_secondTrick.text.toString()
                val thing: String = et_thirdTrick.text.toString()
                setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
                replace(R.id.frameLayout, TricksFragment.newInstance(name, curse, thing))
                addToBackStack(null)
                commit()
            }
        }
    }

    companion object {
        fun create(): DirtyTricksFragment = DirtyTricksFragment()
    }
}
