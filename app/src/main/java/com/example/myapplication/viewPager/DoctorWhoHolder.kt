package com.example.myapplication.viewPager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.card_view.view.*

class DoctorWhoHolder (
    override val containerView: View,
    val context: Context?
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    private val tv_doctor_name = containerView.tv_doctor_name
    private val tv_doctor_description = containerView.tv_doctor_description
    private val viewPager = containerView.viewPager
    private val iv_photo = containerView.iv_photo
    private val indicator = containerView.indicator

    fun bind(doctorWho: DoctorWho) {

        tv_doctor_name.text = doctorWho.name
        tv_doctor_description.text = doctorWho.description
        iv_photo.setImageResource(doctorWho.avatar)
        val map = Doctors.getImageList()
        val imageList: List<Int> = map.getValue(doctorWho.name)
        viewPager.adapter = ViewPager(context, imageList)
        indicator.setViewPager(viewPager)

    }

    companion object{
        fun create(parent: ViewGroup, context: Context?) =
            DoctorWhoHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false),
                context = context
            )
    }
}
