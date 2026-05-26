package com.example.xhwasmobileapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import android.content.Intent
import android.widget.TextView

class ContactDetails : AppCompatActivity() {

    private lateinit var map: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Configuration.getInstance().load(
            applicationContext, getSharedPreferences("osmdroid", MODE_PRIVATE)
        )

        setContentView(R.layout.activity_contact_details)

        map = findViewById(R.id.map)

        // Map style
        map.setTileSource(TileSourceFactory.MAPNIK)

        // Zoom controls
        map.setMultiTouchControls(true)

        // Camera controller
        val mapController = map.controller
        mapController.setZoom(15.0)

        // Location (example: Cape Town)
        val location = GeoPoint(-33.9249, 18.4241)

        // Center map
        mapController.setCenter(location)

        // Marker
        val marker = Marker(map)
        marker.position = location
        marker.title = "Port Elizabeth"

        map.overlays.add(marker)

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

    }
}

//OSmDroid used for the map, because i am not putting in card details for google cloud.
//https://www.youtube.com/watch?v=wRhMhIHg7sM
