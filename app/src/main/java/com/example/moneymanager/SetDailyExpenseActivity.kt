package com.example.moneymanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_set_daily_expense.*

class SetDailyExpenseActivity : AppCompatActivity() {
    private lateinit var dref:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_daily_expense)
        bindWidgets()
        bindListeners()
    }
    private fun bindWidgets(){
        dref =FirebaseDatabase.getInstance().reference

    }
    private fun bindListeners(){
        set_expenses_daily.setOnClickListener {
            val expenseName =area_of_Expenditure.text.toString()
            val expenseAmount =amount_daily.text.toString()

            if(expenseName.isEmpty() || expenseAmount.isEmpty()){
                Toast.makeText(this,"Fill up the fields properly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(expenseAmount.toIntOrNull() == null){
                Toast.makeText(this,"Enter your amount properly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val amount = expenseAmount.toInt()
            val dailyUse:dailyData = dailyData(expenseName,amount)
            println("Starting")
            dref.child("Users").child("expense").child("daily")
                .child(FirebaseAuth.getInstance().currentUser?.email.toString().split("@")[0]).setValue(dailyUse).addOnSuccessListener {
                println("Success")
                Toast.makeText(this,"Successfully Saved Data",Toast.LENGTH_SHORT).show()
                return@addOnSuccessListener
            }.addOnFailureListener {
                Toast.makeText(this,"Failure",Toast.LENGTH_SHORT).show()
                println(it.toString())
                return@addOnFailureListener
            }
            return@setOnClickListener
        }
    }
}
