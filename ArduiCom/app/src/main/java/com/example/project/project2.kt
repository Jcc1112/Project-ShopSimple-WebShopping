package com.example.project

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat


class project2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.project2)

        val back = findViewById<ImageView>(R.id.Back_icon)
        back.setOnClickListener {

            val intent = Intent(this, Project::class.java)
            startActivity(intent)

        }

        val procode2 = findViewById<ImageView>(R.id.code1)
        procode2.setOnClickListener {
            val intent1 = Intent(this, project2code::class.java)
            startActivity(intent1)
        }

            val des1TextView: TextView = findViewById(R.id.des1)

            // Use a multi-line string to format the Arduino code with proper indentation
            val formattedCode = """
<h1>Circuit Assembly Procedure</h1><br><br>
<b>Mount Components:</b> Insert the long leg (anode) of the red LED into one hole on the breadboard. Place the 220-ohm resistor with one end in the same row as the LED's anode and the other end in a separate row. This resistor limits the current to protect the LED.<br><br>

<b>Establish Common Ground: </b>Use a jumper wire to connect the short leg (cathode) of all four LEDs to a single, common row on the breadboard. From that common row, run a jumper wire to the GND pin on the Arduino Uno. This ensures all LEDs share a common ground reference.<br><br> 

<b>Connect Signal Pins:</b>

Connect the free end of the resistor for the first LED to digital pin 13 on the Arduino.<br><br>

Connect the free end of the resistor for the second LED to digital pin 12.<br><br>

Connect the third LED's resistor to digital pin 11.<br><br>

Connect the fourth LED's resistor to digital pin 10.<br><br>

<b>Power Up:</b> Connect the Arduino to your computer via the USB cable.<br>
        """.trimIndent()

            // Set the formatted code as the text of the TextView
            des1TextView.text = HtmlCompat.fromHtml(formattedCode, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}
