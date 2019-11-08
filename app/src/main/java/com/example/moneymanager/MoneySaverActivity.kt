package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.profile_id ->{
                startActivity(Intent(this,ProfileActivity::class.java))
                return true
            }
            R.id.log_out_menu ->{
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(this,LogInActivity::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
