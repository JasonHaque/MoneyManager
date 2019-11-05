package com.example.moneymanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_set_monthly_expense.*

class SetMonthlyExpenseActivity : AppCompatActivity() {
    private var dref:DatabaseReference =FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_monthly_expense)
        bindListeners()
    }
    private fun bindListeners() {
        monthly_amount_setter.setOnClickListener {
            val monthName =monthly_limit.text.toString()
            val monthlyLimit = monthly_amount.text.toString()
            if(monthName.isEmpty() || monthlyLimit.isEmpty()){
                Toast.makeText(this,"Fill up the fields properly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val amount =monthlyLimit.toInt()

        }
    }
}
