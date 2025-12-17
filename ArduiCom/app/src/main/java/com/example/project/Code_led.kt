package com.example.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat


class Code_led : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.code_led)

            val back = findViewById<ImageView>(R.id.Back_icon)
            back.setOnClickListener {

                val intent = Intent(this, led::class.java)
                startActivity(intent)
            }

            val arduinoDescriptionTextView: TextView = findViewById(R.id.arduino_description)

            // Use a multi-line string to format the Arduino code with proper indentation
            val formattedCode = """
void setup() {
  pinMode(LED_BUILTIN, OUTPUT);
}

void loop() {
  digitalWrite(LED_BUILTIN, HIGH);
  delay(1000); // Wait for 1000 millisecond(s)
  digitalWrite(LED_BUILTIN, LOW);
  delay(1000); // Wait for 1000 millisecond(s)
}
        """.trimIndent()

            // Set the formatted code as the text of the TextView
            arduinoDescriptionTextView.text = formattedCode




        val codeexplainationTextView: TextView = findViewById(R.id.code_explaination)

        // Use a multi-line string to format the Arduino code with proper indentation
        val formattedCode2 = """
<b>setup()</b><br>
This function prepares the Arduino board for its task. 
It executes only one time when the board is powered on or reset.<br><br>

<i>void setup():</i> This line defines the setup function, 
    which is designed to not return any value, as indicated by void.<br><br>

<i>pinMode(LED_BUILTIN, OUTPUT);:</i> This command sets up the designated LED pin. 
    It configures the LED_BUILTIN pin to act as an OUTPUT, which allows the 
    board to send electrical signals to it.<br><br><br><br>

<b>loop()</b><br>
This function contains the core logic of the program 
and runs continuously after setup() is finished.<br><br>

<i>void loop():</i> This line defines the loop function, 
    which, like setup(), doesn't return a value.<br><br>

<i>digitalWrite(LED_BUILTIN, HIGH);:</i> This sends a signal to the LED pin, turning it on. 
    The HIGH value provides the voltage needed to illuminate the LED.<br><br>

<i>delay(1000);:</i> This command pauses the program for 1000 milliseconds, or one second. 
    This keeps the LED on for that duration.<br><br>

<i>digitalWrite(LED_BUILTIN, LOW);:</i> This command changes the signal to the LED pin, turning it off. 
    The LOW value stops the voltage, extinguishing the light.<br><br>

<i>delay(1000);:</i> This second pause, lasting one second, keeps the LED off. After this delay, 
    the program automatically cycles back to the start of the loop function, 
    beginning the process all over again.<br><br>

        """.trimIndent()

        // Set the formatted code as the text of the TextView
        codeexplainationTextView.text = HtmlCompat.fromHtml(formattedCode2, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }

}


