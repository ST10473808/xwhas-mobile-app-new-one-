package com.example.xhwasmobileapp

import android.os.Bundle
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.view.View

class Sixmonthcourse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sixmonthcourse)
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

        val btn_more_info = findViewById<Button>(R.id.btn_more_info)
        val btn_more_info2 = findViewById<Button>(R.id.btn_more_info2)
        val btn_more_info3 = findViewById<Button>(R.id.btn_more_info3)
        val btn_more_info4 = findViewById<Button>(R.id.btn_more_info4)

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

            //Takes users to a seperate screen contianing more information about the courses

        }
        btn_more_info.setOnClickListener {
            val intent = Intent(this, First_Aid_info::class.java)
            startActivity(intent)
        }

        btn_more_info2.setOnClickListener {
            val intent = Intent(this, Sewing_info::class.java)
            startActivity(intent)
        }

        btn_more_info3.setOnClickListener {
            val intent = Intent(this, Landscaping_info::class.java)
            startActivity(intent)
        }

        btn_more_info4.setOnClickListener {
            val intent = Intent(this, Life_Skills_info::class.java)
            startActivity(intent)
        }
    }
}