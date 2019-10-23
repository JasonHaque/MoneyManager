package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        bindListeners()
        login()
    }

    fun bindListeners(){
        GotoSignUp.setOnClickListener{
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        LogIn.setOnClickListener{
            login()
        }
    }

    private fun login(){
        var email = EmailField.text.toString()
        var pass = PasswordField.text.toString()
        if(email.isEmpty() || pass.isEmpty()){
            Toast.makeText(this,"Fill up the fields Properly",Toast.LENGTH_SHORT).show()
        }
    }
}
