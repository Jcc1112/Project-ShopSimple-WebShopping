package com.example.project

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat


class project2code : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.project2_code)

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

 pinMode(12, OUTPUT);

 pinMode(11, OUTPUT);

 pinMode(10, OUTPUT);

}



void loop()

{



 digitalWrite(13, HIGH);

 digitalWrite(12, LOW);

 digitalWrite(11, LOW);

 digitalWrite(10, LOW);

 delay(1000);



 digitalWrite(12, HIGH);

 digitalWrite(11, LOW);

 digitalWrite(13, LOW);

 digitalWrite(10, LOW);

 delay(1000);



 digitalWrite(11, HIGH);

 digitalWrite(12, LOW);

 digitalWrite(13, LOW);

 digitalWrite(10, LOW);

 delay(1000);



 digitalWrite(10, HIGH);

 digitalWrite(12, LOW);

 digitalWrite(13, LOW);

 digitalWrite(11, LOW);

 delay(1000);



 digitalWrite(13, HIGH);

 digitalWrite(12, HIGH);

 digitalWrite(11, LOW);

 digitalWrite(10, LOW);

 delay(1000);



 digitalWrite(11, HIGH);

 digitalWrite(10, HIGH);

 digitalWrite(12, LOW);

 digitalWrite(13, LOW);

 delay(1000);



 digitalWrite(13, HIGH);

 digitalWrite(10,HIGH);

 digitalWrite(11, LOW);

 digitalWrite(12,LOW);

 delay(1000);



 digitalWrite(13, HIGH);

 digitalWrite(12, HIGH);

 digitalWrite(11, LOW);

 digitalWrite(10, LOW);

 delay(1000);



 digitalWrite(12,HIGH);

 digitalWrite(11,HIGH);

 digitalWrite(10,LOW);

 digitalWrite(13,LOW);

 delay(1000);



 digitalWrite(11,HIGH);

 digitalWrite(10,HIGH);

 digitalWrite(12,LOW);

 digitalWrite(13,LOW);

 delay(1000);

}
        """.trimIndent()

        // Set the formatted code as the text of the TextView
            arduinoDescriptionTextView.text = formattedCode




            val codeexplainationTextView: TextView = findViewById(R.id.code_explaination)

            // Use a multi-line string to format the Arduino code with proper indentation
            val formattedCode2 = """
<h1>Code Integration and Functionality</h1><br><br>
The provided C++ code creates a sequence of lighting patterns by controlling the state of each digital pin.<br><br>

<b>setup() function:</b> This function initializes all four digital pins (13, 12, 11, and 10) as OUTPUT.<br><br>

<b>loop() function:</b> TThis is the main program loop. It cycles through a series of digitalWrite commands followed by a delay(1000) of 1000 milliseconds (1 second). Each block of code within the loop turns specific LEDs HIGH (on) and others LOW (off) to create different lighting patterns:<br><br>

<b>Single-light chase: </b> The first four blocks of code turn on one LED at a time, creating a simple walking light effect from left to right.<br><br>

<b>Double-light patterns: </b> The subsequent blocks turn on various pairs of LEDs, creating more complex patterns like two lights on at the same time.<br><br>

The continuous repetition of the loop() function makes the sequence of light patterns run indefinitely.<br>

        """.trimIndent()

        // Set the formatted code as the text of the TextView
            codeexplainationTextView.text = HtmlCompat.fromHtml(formattedCode2, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

}


