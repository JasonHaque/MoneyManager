package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_account_details.*

class AccountDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_details)
        bindListeners()
    }

    fun bindListeners(){
        skip_attributes.setOnClickListener{
            startActivity(Intent(this,ProfileActivity::class.java))
        }
    }
}
