package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_account_details.*

class AccountDetailsActivity : AppCompatActivity() {

    private var dref =com.google.firebase.database.FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_details)
        bindListeners()
    }

    fun bindListeners(){
        skip_attributes.setOnClickListener{
            startActivity(Intent(this,ProfileActivity::class.java))
        }
        dref.child("Users").child("Data").child(FirebaseAuth.getInstance().currentUser.toString()).setValue()

    }
}
