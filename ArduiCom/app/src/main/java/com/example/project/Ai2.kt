package com.example.project

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.project.R
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Ai2 : AppCompatActivity() {

    // ⚠️ IMPORTANT: Replace "YOUR_NEW_API_KEY_HERE" with your valid, renewed key.
    // In a real app, load this securely from BuildConfig or a secrets manager.
    private val newApiKey = "AIzaSyB2KRlYXaKVI3DFo2Ih0VOAiU2YGA_WtZM"

    // Initialize the GenerativeModel client. This is safe on the main thread.
    private val model = GenerativeModel(
        modelName = "gemini-2.5-flash", // Use the model you prefer
        apiKey = newApiKey
    )

    private lateinit var resultTextView: TextView
    private lateinit var generateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Assume you have defined 'activity_main.xml' with TextView and Button
        setContentView(R.layout.ai2)

        resultTextView = findViewById(R.id.resultTextView)
        generateButton = findViewById(R.id.generateButton)

        generateButton.setOnClickListener {
            val prompt = "Explain the difference between a microcontroller and a microprocessor in two sentences."
            resultTextView.text = "Loading..." // Show loading state
            generateContentAndDisplay(prompt)
        }
    }

    /**
     * Executes the Gemini API call asynchronously using Kotlin Coroutines.
     * @param prompt The text prompt to send to the Gemini model.
     */
    private fun generateContentAndDisplay(prompt: String) {

        // Launch a coroutine on the I/O thread (suitable for network/disk operations)
        lifecycleScope.launch(Dispatchers.IO) {

            try {
                // 3. The API call (network operation) happens safely in the background
                val response = model.generateContent(prompt)

                // 4. Switch back to the main thread (Dispatchers.Main) to update the UI
                withContext(Dispatchers.Main) {
                    resultTextView.text = response.text
                }

            } catch (e: Exception) {
                // Log and display any errors
                Log.e("GeminiAPI", "API Call Error: ${e.message}", e)

                // Switch back to the main thread to update the UI with the error
                withContext(Dispatchers.Main) {
                    resultTextView.text = "Error: ${e.message ?: "Unknown API error"}"
                }
            }
        }
    }
}