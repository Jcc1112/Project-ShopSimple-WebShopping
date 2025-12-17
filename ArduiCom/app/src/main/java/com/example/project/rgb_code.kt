package com.example.project

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat


class rgb_code : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rgb_code)

        val back = findViewById<ImageView>(R.id.Back_icon)
        back.setOnClickListener {

            val intent = Intent(this, rgbled::class.java)
            startActivity(intent)
        }

        val arduinoDescriptionTextView: TextView = findViewById(R.id.arduino_description)

        // Use a multi-line string to format the Arduino code with proper indentation
        val formattedCode = """
void setup()
{
  pinMode(0, OUTPUT); //RED
  pinMode(1, OUTPUT); //Blue
  pinMode(2, OUTPUT); //Green
}

void loop()
{
  //color Red
  digitalWrite(0, HIGH);
  delay(1000); 
  digitalWrite(0, LOW);
  delay(1000);
  
  //color margenta
  digitalWrite(0, HIGH);
  digitalWrite(1, HIGH);
  delay(1000); 
  digitalWrite(0, LOW);
  digitalWrite(1, LOW);
  delay(1000);
  
  //color Green
  digitalWrite(2, HIGH);
  delay(1000); 
  digitalWrite(2, LOW);
  delay(1000);
  
  //color White
  digitalWrite(0, HIGH);
  digitalWrite(1, HIGH);
  digitalWrite(2, HIGH);
  delay(1000); 
  digitalWrite(0, LOW);
  digitalWrite(1, LOW);
  digitalWrite(2, LOW);
  delay(1000);
  
  //color Yellow
  digitalWrite(0, HIGH);
  digitalWrite(2, HIGH);
  delay(1000); 
  digitalWrite(0, LOW);
  digitalWrite(2, LOW);
  delay(1000);
  
  //color Blue
  digitalWrite(1,HIGH);
  delay(1000); 
  digitalWrite(1,LOW);
  delay(1000);
  
   //color Cyan
  digitalWrite(1,HIGH);
  digitalWrite(2,HIGH);
  delay(1000); 
  digitalWrite(1,LOW);
  digitalWrite(2,LOW);
  delay(1000);
}
        """.trimIndent()

        // Set the formatted code as the text of the TextView
        arduinoDescriptionTextView.text = formattedCode




        val codeexplainationTextView: TextView = findViewById(R.id.code_explaination)

        // Use a multi-line string to format the Arduino code with proper indentation
        val formattedCode2 = """
<b>setup()</b><br>
The setup() function runs once at the beginning to configure the necessary pins for output.<br><br>

<i>pinMode(0, OUTPUT); //RED:</i> This line configures digital pin 0 as an output. It's dedicated to controlling the red LED within the RGB component.<br><br>

<i>pinMode(1, OUTPUT); //Blue:</i> This line sets digital pin 1 as an output. This pin will control the blue LED.<br><br>

<i>pinMode(2, OUTPUT); //Green:</i> This line configures digital pin 2 as an output. It's responsible for controlling the green LED.<br><br><br><br>

<b>loop()</b><br>
The loop() function runs repeatedly, executing a sequence of commands to change the LED's color. Each color is created by turning on one or more of the red, green, or blue pins.<br><br>

<i>color Red:</i> The code turns on only the red pin (pin 0) by setting it to HIGH. After a one-second delay, the pin is set to LOW to turn the color off before the next color sequence.<br><br>

<i>color Magenta:</i> This color is created by turning on both the red (pin 0) and blue (pin 1) pins. Both pins are set to HIGH for one second before being turned off.<br><br>

<i>color Green:</i> Only the green pin (pin 2) is turned on with HIGH. The code then pauses for one second before turning the green pin off with LOW.<br><br>

<i>color White:</i> All three pins (red, blue, and green) are set to HIGH simultaneously. Combining these three primary colors of light creates white light.<br><br>

<i>color Yellow:</i> This color is produced by turning on the red (pin 0) and green (pin 2) pins. Both pins are held HIGH for one second and then turned off.<br><br>

<i>color Blue:</i> Only the blue pin (pin 1) is activated by setting it to HIGH. After a one-second delay, the pin is turned off.<br><br>

<i>color Cyan:</i> The code turns on the blue (pin 1) and green (pin 2) pins. This combination of primary colors creates cyan. The pins are turned off after the one-second delay, and the entire loop() function then restarts.

        """.trimIndent()

        // Set the formatted code as the text of the TextView
        codeexplainationTextView.text = HtmlCompat.fromHtml(formattedCode2, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

}


