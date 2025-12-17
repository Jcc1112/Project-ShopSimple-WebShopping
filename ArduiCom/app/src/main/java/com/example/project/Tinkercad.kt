package com.example.project

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat


class Tinkercad : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tinkercad)



        val profilebtn= findViewById<ImageView>(R.id.profile_icon)
        profilebtn.setOnClickListener {
            val intent5 = Intent(this, Profile::class.java)
            startActivity(intent5)
            true
        }

        val tbtn = findViewById<Button>(R.id.btn)
        tbtn.setOnClickListener {

            val intent2= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tinkercad.com/"))
            startActivity(intent2)

        }

        val back = findViewById<ImageView>(R.id.Back_icon)
        back.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }



        val arduinoDescriptionTextView: TextView = findViewById(R.id.arduino_description)

        // Use a multi-line string to format the Arduino code with proper indentation
        val formattedCode = """
        Tinkercad is a free, browser-based 3D design and modeling software developed by Autodesk. It's renowned for its simplicity, making it an excellent tool for beginners in 3D printing, electronics, and coding.
        Users build 3D models by dragging and dropping basic shapes like cubes and cylinders onto a workplane. These shapes can be combined or used as "holes" to subtract from other forms, creating complex designs with ease.
        Beyond 3D design, Tinkercad includes "Circuits" for simulating electronic projects, even with Arduino microcontrollers, and "Codeblocks" for generating 3D models using visual, block-based programming. Its accessibility and intuitive interface have made it a popular educational platform for fostering creativity and STEM skills.
        """.trimIndent()

        // Set the formatted code as the text of the TextView
        arduinoDescriptionTextView.text = formattedCode



    }

}


