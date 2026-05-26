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


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



            val dropdown = findViewById<TextView>(R.id.dropdown)
            val dropdownLayout = findViewById<LinearLayout>(R.id.dropdown_layout)

            val sixMonthCourse = findViewById<TextView>(R.id.Six_Month_Course)
            val sixWeekCourse = findViewById<TextView>(R.id.Six_Week_Course)
            val home = findViewById<TextView>(R.id.home)
            val contact = findViewById<TextView>(R.id.contact)
            val calculate_fees = findViewById<TextView>(R.id.calculate_fees)
            val six_week_course = findViewById<TextView>(R.id.six_week_course)
            val six_month_course = findViewById<TextView>(R.id.six_month_course)

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

            //Dropdown menu

            dropdown.setOnClickListener {

                if (dropdownLayout.visibility == View.GONE) {

                    dropdownLayout.visibility = View.VISIBLE
                    dropdown.text = "Select a Course ^"

                } else {
                    dropdownLayout.visibility = View.GONE
                    dropdown.text = "Select a Course >"
                }
            }

            sixMonthCourse.setOnClickListener {
                val intent = Intent(this, Sixmonthcourse::class.java)
                startActivity(intent)
            }

            sixWeekCourse.setOnClickListener {
                val intent = Intent(this, sixweekcourse::class.java)
                startActivity(intent)
            }


        }

}
