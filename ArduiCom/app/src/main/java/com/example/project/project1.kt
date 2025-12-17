package com.example.project

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat


class project1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.project1)

        val back = findViewById<ImageView>(R.id.Back_icon)
        back.setOnClickListener {

            val intent = Intent(this, Project::class.java)
            startActivity(intent)

        }



            val des1TextView: TextView = findViewById(R.id.des1)

            // Use a multi-line string to format the Arduino code with proper indentation
            val formattedCode = """
<h1>Circuit Assembly Procedure</h1><br><br>
<b>Mount the LED and Resistor:</b> Insert the long leg (anode) of the red LED into one hole on the breadboard. Place the 220-ohm resistor with one end in the same row as the LED's anode and the other end in a separate row. This resistor limits the current to protect the LED.<br><br>

<b>Connect to Arduino:</b><br><br> 

Using a jumper wire, connect the other leg of the LED (the shorter leg or cathode) to the GND (ground) pin on the Arduino Uno. This completes the negative side of the circuit.<br><br>

Use another jumper wire to connect the resistor's free end to digital pin 13 on the Arduino. This will be the signal pin that controls the LED.<br><br>

<b>Power Up:</b> Connect the Arduino Uno to your computer using the USB cable. This will provide power to the board and allow you to upload the code.<br>

        """.trimIndent()

            // Set the formatted code as the text of the TextView
        des1TextView.text = HtmlCompat.fromHtml(formattedCode, HtmlCompat.FROM_HTML_MODE_LEGACY)

        val procode1 = findViewById<ImageView>(R.id.code1)
        procode1.setOnClickListener {
            val intent1 = Intent(this, project1code::class.java)
            startActivity(intent1)
        }
    }


}

