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
        dref =FirebaseDatabase.getInstance().reference.child("Users").child("DailyExpenses")
            .child(FirebaseAuth.getInstance().currentUser?.email.toString().split("@")[0])

    }
    private fun bindListeners(){
        set_expenses_daily.setOnClickListener {
            val ExpenseName =area_of_Expenditure.text.toString()
            val ExpenseAmount =amount_daily.text.toString()

            if(ExpenseName.isEmpty() || ExpenseAmount.isEmpty()){
                Toast.makeText(this,"Fill up the fields properly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }
}
