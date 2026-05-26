package com.example.xhwasmobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class sixweekcourse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sixweekcourse)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val home = findViewById<TextView>(R.id.home)
        val contact = findViewById<TextView>(R.id.contact)
        val calculate_fees = findViewById<TextView>(R.id.calculate_fees)
        val six_week_course = findViewById<TextView>(R.id.six_week_course)
        val six_month_course = findViewById<TextView>(R.id.six_month_course)

        val btn_more_info3 = findViewById<TextView>(R.id.btn_more_info3)
        val btn_more_info2 = findViewById<TextView>(R.id.btn_more_info2)
        val btn_more_info = findViewById<TextView>(R.id.btn_more_info)

        //Used to navigate to other screens

        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        contact.setOnClickListener {
            val intent = Intent(this, ContactDetails::class.java)
            startActivity(intent)
        }

        calculate_fees.setOnClickListener {
            val intent = Intent(this, CalculateFees::class.java)
            startActivity(intent)
        }

        six_week_course.setOnClickListener {
            val intent = Intent(this, sixweekcourse::class.java)
            startActivity(intent)
        }

        six_month_course.setOnClickListener {
            val intent = Intent(this, Sixmonthcourse::class.java)
            startActivity(intent)
        }

        // Takes user to a seperate screen contianing more information about the courses

       btn_more_info3.setOnClickListener {
           val intent = Intent(this, Garden_Maintenance_info::class.java)
           startActivity(intent)
       }
        btn_more_info2.setOnClickListener {
            val intent = Intent(this, Cooking_info::class.java)
            startActivity(intent)
        }
        btn_more_info.setOnClickListener {
            val intent = Intent(this, Child_Minding_info::class.java)
            startActivity(intent)
        }
    }
}
