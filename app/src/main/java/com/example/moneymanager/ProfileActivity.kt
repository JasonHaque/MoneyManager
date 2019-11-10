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
    private var dref = FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        title = "Profile"
        bindWidgets()
        bindListeners()
    }

    private fun bindWidgets(){
        Profile_view.text = firebaseAuth.currentUser?.email.toString()
        val newref =dref.child("Users").child("Data").
            child(FirebaseAuth.getInstance().currentUser?.email.toString().split("@")[0])
        newref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                println("Error receiving data")
            }

            override fun onDataChange(p0: DataSnapshot) {

                val children = p0!!.children
                children.forEach{
                    if(it.key.equals("address")){
                        address_view.text=it.value.toString()
                    }
                    else if(it.key.equals("salary")){
                        salary_view.text=it.value.toString()
                    }
                    else if(it.key.equals("occupation")){
                        occupation_view.text=it.value.toString()
                    }
                }

            }

        })

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
        go_to_timeline.setOnClickListener {
            startActivity(Intent(this,MoneySaverActivity::class.java))
        }

    }
}
