package com.example.moneymanager

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {

    var firebaseAuth=FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        bindListeners()
    }

    private fun bindListeners(){
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
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnSuccessListener {
            Toast.makeText(this,"Success",Toast.LENGTH_LONG).show()
            val intent=Intent(this,TimelineActivity::class.java)
            startActivity(intent)
        }
    }
}
