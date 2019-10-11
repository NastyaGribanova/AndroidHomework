package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import layout.PasswordRepository
import kotlinx.android.synthetic.main.activity_change_login.*

class ChangeLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_login)
    }

    fun onClick2(view: View) {
        PasswordRepository.password = textInputEditText.text.toString()
        onBackPressed()
    }
}
