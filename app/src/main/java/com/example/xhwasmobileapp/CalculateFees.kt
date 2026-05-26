package com.example.xhwasmobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.Color

//Sotres the information of the courses

data class Course(
    val name: String,
    val price: Int
)

class CalculateFees : AppCompatActivity() {

    //stores all selected courses
    private val selectedCourses = mutableListOf<Course>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculate_fees)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Navigation

        val home = findViewById<TextView>(R.id.home)
        val contact = findViewById<TextView>(R.id.contact)
        val calculate_fees = findViewById<TextView>(R.id.calculate_fees)
        val six_week_course = findViewById<TextView>(R.id.six_week_course)
        val six_month_course = findViewById<TextView>(R.id.six_month_course)

        // Course selection
        val btn_first_aid = findViewById<TextView>(R.id.btn_first_aid)
        val btn_Sewing = findViewById<TextView>(R.id.btn_Sewing)
        val btn_Landscaping = findViewById<TextView>(R.id.btn_Landscaping)
        val btn_Life_skills = findViewById<TextView>(R.id.btn_Life_skills)
        val btn_Child_Minding = findViewById<TextView>(R.id.btn_Child_Minding)
        val btn_Cooking = findViewById<TextView>(R.id.btn_Cooking)
        val btn_Garden_Maintenance = findViewById<TextView>(R.id.btn_Garden_Maintenance)
        val btn_calculate = findViewById<TextView>(R.id.btn_calculate)
        val btn_Total = findViewById<TextView>(R.id.btn_Total)
        val btn_clear = findViewById<TextView>(R.id.btn_clear)

        // Navigation buttons

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


        // Course selection buttons

        btn_first_aid.setOnClickListener {
            toggleCourse(Course("First Aid", 1500), btn_first_aid)
        }

        btn_Sewing.setOnClickListener {
            toggleCourse(Course("Sewing", 1500), btn_Sewing)
        }

        btn_Landscaping.setOnClickListener {
            toggleCourse(Course("Landscaping", 1500), btn_Landscaping)
        }

        btn_Life_skills.setOnClickListener {
            toggleCourse(Course("Life skills", 1500), btn_Life_skills)
        }

        btn_Child_Minding.setOnClickListener {
            toggleCourse(Course("Child Minding", 750), btn_Child_Minding)
        }

        btn_Cooking.setOnClickListener {
            toggleCourse(Course("Cooking", 750), btn_Cooking)
        }

        btn_Garden_Maintenance.setOnClickListener {
            toggleCourse(Course("Garden Maintenance", 750), btn_Garden_Maintenance)
        }

        //Resets the list of courses and the total amount

        btn_clear.setOnClickListener {
            selectedCourses.clear()

            btn_Total.text = "Total: R0"

            //Resets the colour of the buttons

            btn_first_aid.setBackgroundColor(Color.parseColor("#DAA520"))
            btn_Sewing.setBackgroundColor(Color.parseColor("#DAA520"))
            btn_Landscaping.setBackgroundColor(Color.parseColor("#DAA520"))
            btn_Life_skills.setBackgroundColor(Color.parseColor("#DAA520"))
            btn_Child_Minding.setBackgroundColor(Color.parseColor("#DAA520"))
            btn_Cooking.setBackgroundColor(Color.parseColor("#DAA520"))
            btn_Garden_Maintenance.setBackgroundColor(Color.parseColor("#DAA520"))
        }

            //Used to work out the discounts

            btn_calculate.setOnClickListener {
                val total = selectedCourses.sumOf { it.price }
                val courseCount = selectedCourses.size

                val discount = when {
                    courseCount == 1 -> 0
                    courseCount == 2 -> 5
                    courseCount == 3 -> 10
                    else -> if (courseCount > 3) 15 else 0
                }

                val discountedTotal = total - (total * discount / 100)
                val finalTotal = discountedTotal

                btn_Total.text = "Total: R$finalTotal"

            }
        }

        //Selects and deselects the courses
        private fun toggleCourse(course: Course, button: TextView) {
            val existingCourse = selectedCourses.find { it.name == course.name }

            if (existingCourse != null) {
                selectedCourses.remove(existingCourse)

                //Resets the colour of the buttons

                button.setBackgroundColor(Color.parseColor("#DAA520"))

            } else {
                selectedCourses.add(course)

                //Resets the colour of the buttons

                button.setBackgroundColor(Color.GREEN)

            }
        }
    }

