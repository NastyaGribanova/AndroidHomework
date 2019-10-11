package com.example.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import layout.PasswordRepository
import kotlinx.android.synthetic.main.activity_login.et_sign_in_pass as et_sign_in_pass1

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_sign_in_pass1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                ti_sign_in_pass.error = null
                ti_sign_in_pass.isErrorEnabled = false
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }


    private fun setPasswordError() {
        ti_sign_in_pass.error = getString(R.string.validate_password)
    }

    fun onClick(view: View) {
        if (et_sign_in_pass1.getText().toString() == PasswordRepository.password){
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        } else setPasswordError()
    }

    fun onClick2(view: View) {
        val intent = Intent(this, ChangeLoginActivity::class.java )
        startActivity(intent)
    }


}
