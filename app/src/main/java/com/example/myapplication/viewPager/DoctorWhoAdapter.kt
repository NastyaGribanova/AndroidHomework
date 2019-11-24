package com.example.myapplication.viewPager

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DoctorWhoAdapter(
    private var doctorWho: ArrayList<DoctorWho>,
    val context: Context?
) : RecyclerView.Adapter<DoctorWhoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorWhoHolder =
        DoctorWhoHolder.create(parent, context)

    override fun getItemCount(): Int = doctorWho.size

    override fun onBindViewHolder(holder: DoctorWhoHolder, position: Int) {
        holder.bind(doctorWho[position])
    }

}
