package com.example.myapplication.recyclerView

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_companion.*

class CompanionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_companion)
        tv_name_companion_activity.text =
            "Name: " + intent?.extras?.getString(KEY_COMPANION_NAME) ?: "DEFAULT NAME"
        tv_description_companion_activity.text =
            "Description: " + intent?.extras?.getString(KEY_COMPANION_DESCRIPTION) ?: "DEFAULT NAME"
    }

    companion object {
        private const val KEY_COMPANION_NAME = "name"
        private const val KEY_COMPANION_DESCRIPTION = "description"

        fun createIntent(
            activity: Activity,
            companion: CompanionRecycler
        ) = Intent(activity, CompanionActivity::class.java).apply {
            putExtra(KEY_COMPANION_NAME, companion.name)
            putExtra(KEY_COMPANION_DESCRIPTION, companion.description)
        }
    }
}
