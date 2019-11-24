package com.example.myapplication.bottomNavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.viewPager.*
import kotlinx.android.synthetic.main.doctor_who_fragment.*

class DoctorWhoFragment : Fragment() {

    private var adapter: DoctorWhoAdapter? = null

    companion object {
        fun newInstance() = DoctorWhoFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.doctor_who_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_doctor.layoutManager = LinearLayoutManager(context)
        adapter = DoctorWhoAdapter(Doctors.getDataSource(), context)
        rv_doctor?.adapter = adapter
    }

}
