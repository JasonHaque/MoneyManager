package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
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
            val occupation="Not set"
            val salary = "0"
            val address = "Not set"
            val new_salary= salary.toInt()
            val Data = UserData(occupation,new_salary,address)
            val intent =Intent(this,ProfileActivity::class.java).putExtra("Info",Data)
            startActivity(intent)

        }
        set_attributes.setOnClickListener{
            val occupation=occupation.text.toString()
            val salary = salary.text.toString()
            val address = Address.text.toString()
            if (occupation.isEmpty() || salary.isEmpty() || address.isEmpty()){
                Toast.makeText(this ,"Fill these properly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val newSalary= salary.toInt()
            val data = UserData(occupation,newSalary,address)
            dref.child("Users").child("Data").child(FirebaseAuth.getInstance().currentUser?.email.toString().split("@")[0])
                .setValue(data).addOnSuccessListener {
                    Toast.makeText(this,"Success",Toast.LENGTH_LONG).show()
                    val info =UserData(occupation,newSalary,address)
                    val intent =Intent(this,ProfileActivity::class.java).putExtra("Info",info)
                    startActivity(intent)

                }
        }


    }
}
