package com.example.project

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat


class project1code : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.project1_code)

        val back = findViewById<ImageView>(R.id.Back_icon)
        back.setOnClickListener {

            val intent = Intent(this, project1::class.java)
            startActivity(intent)
        }

            val arduinoDescriptionTextView: TextView = findViewById(R.id.arduino_description)

            // Use a multi-line string to format the Arduino code with proper indentation
            val formattedCode = """
void setup()

{

pinMode(13, OUTPUT);

}

void loop()

{
digitalWrite(13, HIGH);
delay(1000); // Wait for 1000 millisecond(s)
digitalWrite(13, LOW);
delay(1000); // Wait for 1000 millisecond(s)
}
        """.trimIndent()

        // Set the formatted code as the text of the TextView
            arduinoDescriptionTextView.text = formattedCode




            val codeexplainationTextView: TextView = findViewById(R.id.code_explaination)

            // Use a multi-line string to format the Arduino code with proper indentation
            val formattedCode2 = """
<h1>Code Integration and Functionality</h1><br><br>
The provided C++ code is a classic "Blink" program for the Arduino. Here’s what it does and how it integrates with the circuit:<br><br>

<b>setup() function:</b> This function runs only once when the Arduino is powered on. pinMode(13, OUTPUT) configures digital pin 13 as an output, meaning it will send a voltage signal to the LED.<br><br>

<b>loop() function:</b> This function runs continuously after setup() is finished, creating the blinking effect.<br><br>

<b>digitalWrite(13, HIGH)</b> sends a high voltage signal to pin 13, turning the LED on.<br><br>

<b>delay(1000)</b> pauses the program for 1000 milliseconds (1 second), keeping the LED on for that duration.<br><br>

<b>digitalWrite(13, LOW)</b> sends a low voltage signal to pin 13, turning the LED off.<br><br>

<b>delay(1000)</b> pauses the program for another 1 second, keeping the LED off.<br><br>

This cycle repeats indefinitely, causing the LED to blink on and off every second. The physical connections on the breadboard (pin 13 to the resistor/LED and the LED to GND) allow the Arduino to control the flow of electricity to the LED based on the signals sent from pin 13.<br><br>

        """.trimIndent()

        // Set the formatted code as the text of the TextView
            codeexplainationTextView.text = HtmlCompat.fromHtml(formattedCode2, HtmlCompat.FROM_HTML_MODE_LEGACY)


    }

}


