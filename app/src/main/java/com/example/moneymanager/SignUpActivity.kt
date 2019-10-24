package com.example.moneymanager

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private var firebaseAuth=FirebaseAuth.getInstance()
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
        val email=signUpMail.text.toString()
        val pass =signUpPassword.text.toString()
        val confirm = ConfirmPassword.text.toString()
        if(email.isEmpty() || pass.isEmpty() || confirm.isEmpty()){
            Toast.makeText(this,"Fill in all the fields",Toast.LENGTH_SHORT).show()
            return
        }
        if(! pass.equals(confirm)){
            Toast.makeText(this,"Passwords Do not match",Toast.LENGTH_SHORT).show()
            return
        }
        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnSuccessListener {
            Toast.makeText(this,"Success",Toast.LENGTH_LONG).show()
            val intent =Intent(this,AccountDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}
