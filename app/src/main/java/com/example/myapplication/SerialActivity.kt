package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_serial.*

class SerialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serial)
        tv_name_serial_activity.text =
            "Name: " + intent?.extras?.getString(KEY_FILM_NAME) ?: "DEFAULT NAME"
        tv_duration_serial_activity.text =
            "Duration: " + intent?.extras?.getString(KEY_FILM_DURATION) ?: "DEFAULT NAME"
        tv_description_serial_activity.text =
            "Description: " + intent?.extras?.getString(KEY_FILM_DESCRIPTION) ?: "DEFAULT NAME"
        iv_serial_activity.setImageResource(intent?.extras?.getInt(KEY_FILM_IMAGE) ?: 11)
    }

    companion object {
        private const val KEY_FILM_NAME = "name"
        private const val KEY_FILM_DURATION = "duration"
        private const val KEY_FILM_DESCRIPTION = "description"
        private const val KEY_FILM_IMAGE = "image"

        fun createIntent(
            activity: Activity,
            serial: Serial
        ) = Intent(activity, SerialActivity::class.java).apply {
            putExtra(KEY_FILM_NAME, serial.name)
            putExtra(KEY_FILM_DURATION, serial.duration)
            putExtra(KEY_FILM_DESCRIPTION, serial.description)
            putExtra(KEY_FILM_IMAGE, serial.image)
        }
    }
}
