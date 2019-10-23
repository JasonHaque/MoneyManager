package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private var firebaseAuth =FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        bindWidgets()
        bindListeners()
    }

    private fun bindWidgets(){
        Profile_view.setText(firebaseAuth.currentUser?.email.toString())
    }
    private fun bindListeners(){
        logOut.setOnClickListener{
            firebaseAuth.signOut()
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }
    }
}
