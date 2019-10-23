package com.example.moneymanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        bindListeners()
    }

    private fun bindListeners(){
        SignUp.setOnClickListener{
            signup()
        }
    }

    private fun signup(){
        var email=signUpMail.text.toString()
        var pass =signUpPassword.text.toString()
        var confirm = ConfirmPassword.text.toString()
        if(email.isEmpty() || pass.isEmpty() || confirm.isEmpty()){
            Toast.makeText(this,"Fill in all the fields",Toast.LENGTH_SHORT).show()
            return
        }
        if(! pass.equals(confirm)){
            Toast.makeText(this,"Passwords Do not match",Toast.LENGTH_SHORT).show()
            return
        }
    }
}
