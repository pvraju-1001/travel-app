package com.example.travelphotoapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var currentImageIndex = 0
    lateinit var image: ImageView
    val places = arrayOf("Taj Mahal - Agra", "India Gate - Delhi", "Red Fort - Delhi", "Lotus Temple - Delhi", "Charminar - Hyderabad")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var place = findViewById<TextView>(R.id.place)
        place.text = places[currentImageIndex]
        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)

        next.setOnClickListener {
            var currentImageName = "pic$currentImageIndex"
            var currentImageId = this.resources.getIdentifier(currentImageName, "id", packageName)
            image = findViewById<ImageView>(currentImageId)
            image.alpha = 0f;

            currentImageIndex = (currentImageIndex + 1) % 5

            var nextImageName = "pic$currentImageIndex"
            var nextImageId = this.resources.getIdentifier(nextImageName, "id", packageName)
            image = findViewById<ImageView>(nextImageId);
            image.alpha = 1f;
            place.text = places[currentImageIndex]
        }

        prev.setOnClickListener {
            var currentImageName = "pic$currentImageIndex"
            var currentImageId = this.resources.getIdentifier(currentImageName, "id", packageName)
            image = findViewById<ImageView>(currentImageId)
            image.alpha = 0f;

            currentImageIndex = (currentImageIndex + 4) % 5

            var previousImageName = "pic$currentImageIndex"
            var previousImageId = this.resources.getIdentifier(previousImageName, "id", packageName)
            image = findViewById<ImageView>(previousImageId);
            image.alpha = 1f
            place.text = places[currentImageIndex]
        }
    }
}