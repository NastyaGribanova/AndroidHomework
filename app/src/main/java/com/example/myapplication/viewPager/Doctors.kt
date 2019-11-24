package com.example.myapplication.viewPager

import com.example.myapplication.R

object Doctors {

    fun getDataSource(): ArrayList<DoctorWho> = arrayListOf(
        DoctorWho("9th Doctor", "Nicolas Cage na minimalcah", R.drawable.img9doctor),
        DoctorWho("10th Doctor", "My lovely Doctor by David Tennant", R.drawable.img10doctor),
        DoctorWho("11th Doctor", "Cute Doctor with bow-tie", R.drawable.img11doctor),
        DoctorWho("12th Doctor", "The most charismatic Doctor", R.drawable.img12doctor),
        DoctorWho("Doctor", "Just Doctor", R.drawable.imgalldoctors)
    )

    fun getImageList(): Map<String, ArrayList<Int>> = mapOf(
        "9th Doctor" to arrayListOf(R.drawable.img9doctorwho , R.drawable.img9doctor),
        "10th Doctor" to arrayListOf(R.drawable.img10doctorwho , R.drawable.img10doctor),
        "11th Doctor" to arrayListOf(R.drawable.img11doctorwho , R.drawable.img11doctor),
        "12th Doctor" to arrayListOf(R.drawable.img12doctorwho , R.drawable.img12doctor),
        "Doctor" to arrayListOf(R.drawable.imgalldoctorswho , R.drawable.imgalldoctors)
    )
}
