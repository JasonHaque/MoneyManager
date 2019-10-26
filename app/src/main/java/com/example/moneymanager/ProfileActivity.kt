package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private var firebaseAuth =FirebaseAuth.getInstance()
    private var dref = FirebaseDatabase.getInstance().getReference()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        bindWidgets()
        bindListeners()
    }

    private fun bindWidgets(){
        Profile_view.text = firebaseAuth.currentUser?.email.toString()
        val ref =dref.child("Users").child("Data")
            .child(FirebaseAuth.getInstance().currentUser?.email.toString().split("@")[0])
        val listener = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                println("Not Implemented yet")
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()){
                    print(dataSnapshot.value)
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
    private fun bindListeners(){
        logOut.setOnClickListener{
            firebaseAuth.signOut()
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }
        set_missing_attributes.setOnClickListener {
            startActivity(Intent(this,AccountDetailsActivity::class.java))
        }

    }
}
