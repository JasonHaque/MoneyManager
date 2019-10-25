package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        set_attributes.setOnClickListener{
            val occupation=occupation.text.toString()
            val salary = salary.text.toString()
            val address = Address.text.toString()
            if (occupation.isEmpty() || salary.isEmpty() || address.isEmpty()){
                Toast.makeText(this ,"Fill these properly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val new_salary= salary.toInt()
            val Data = UserData(occupation,new_salary,address)
        }

    }
}
