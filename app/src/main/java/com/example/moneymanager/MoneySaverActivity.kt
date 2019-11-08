package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_money_saver.*

class MoneySaverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money_saver)
        bindListeners()
    }
    fun bindListeners(){
        monthly_expenses.setOnClickListener {
            val intent =Intent(this,MonthlyExpenseActivity::class.java)
            startActivity(intent)
        }
        daily_expenses.setOnClickListener {
            val intent =Intent(this,DailyExpenseActivity::class.java)
            startActivity(intent)
        }
        set_monthly_expenses.setOnClickListener {
            val intent =Intent(this,SetMonthlyExpenseActivity::class.java)
            startActivity(intent)
        }
        set_daily_expenses.setOnClickListener {
            val intent =Intent(this,SetDailyExpenseActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

}
