package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_account_details.*
import kotlinx.android.synthetic.main.activity_profile.*

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
            dref.child("Users").child("Data").child(FirebaseAuth.getInstance().currentUser?.email.toString().split("@")[0])
                .setValue(Data).addOnSuccessListener {
                    Toast.makeText(this,"Success",Toast.LENGTH_LONG).show()
                    val ref =dref.child("Users").child("Data")
                        .child(FirebaseAuth.getInstance().currentUser?.email.toString().split("@")[0])
                    val listener = object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError) {
                            println("Not Implemented yet")
                        }

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()){
                                print(dataSnapshot)
                                //val datasetter = dataSnapshot.getValue(UserData::class.java)
                                //println(datasetter?.occupation+"         "+datasetter?.salary)
                                //occupation_view.text= datasetter?.occupation
                                //salary_view.text=datasetter?.salary.toString()
                                //address_view.text=datasetter?.address
                            }

                        }

                    }
                    ref.addValueEventListener(listener)

                }
        }


    }
}
