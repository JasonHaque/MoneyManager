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
        setTitle("Profile")
        bindWidgets()
        bindListeners()
    }

    private fun bindWidgets(){
        Profile_view.text = firebaseAuth.currentUser?.email.toString()
        val inf:UserData = intent.extras!!["Info"] as UserData
        occupation_view.text= inf.occupation
        salary_view.text=inf.salary.toString()
        address_view.text=inf.address

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
