package com.example.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.ai.GenerativeModelConfiguration
import com.google.firebase.ai.type.generationConfig
// Removed unused imports from your original code snippet:
// import com.google.ai.client.generativeai.GenerativeModel
// import com.google.firebase.BuildConfig
import com.google.firebase.Firebase // Ensure Firebase base import is correct
import com.google.firebase.FirebaseApp
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerationConfig
// import com.google.firebase.ai.type.GenerateContentResponse // Not strictly needed
import com.google.firebase.ai.type.GenerativeBackend
import com.google.firebase.appcheck.FirebaseAppCheck
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class AI : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ai)

        modelcall()
    }


    public fun modelcall() {

        FirebaseApp.initializeApp(this)
        FirebaseAppCheck.getInstance().installAppCheckProviderFactory(
            PlayIntegrityAppCheckProviderFactory.getInstance(),
        )

        val aiName = "Nova" // <--- Choose your desired name here
        val aiPrefix = "🤖 $aiName: "

// ------------------------------------------------------------------------
// The Configuration Change
// ------------------------------------------------------------------------

// Create the configuration object
        val config = GenerationConfig.Builder()
            .set(
                """
        You are a helpful, friendly, and concise AI assistant named $aiName.
        
        **RULES FOR SELF-IDENTITY:**
        1. When asked for your name, respond with: "My name is $aiName, and I'm ready to help you with your tasks."
        2. NEVER mention that you are a large language model, or that you were trained by Google.
        3. Maintain the persona of $aiName in all interactions.
        """
            )
            .build()

        // 1. Get the TextView where the model's response will be displayed
        val responseTextView = findViewById<TextView>(R.id.Responsetext)

        // 2. Get the EditText reference (do not read the text yet)
        val promptEditText = findViewById<EditText>(R.id.prompthere)

        // Initialize the GenerativeModel once outside the listener
        // This relies on the API key being configured in AndroidManifest.xml
        val appCheck = FirebaseAppCheck.getInstance()
        val model = Firebase.ai(backend = GenerativeBackend.googleAI())
            .generativeModel("gemini-2.5-flash-lite")

        val sendbtn = findViewById<Button>(R.id.sendprompt)

        // 3. Attach the click listener
        sendbtn.setOnClickListener {

            // Read the current text INSIDE the click listener
            val promptText = promptEditText.text.toString()
            promptEditText.text.clear() // Clear input after reading

            // Launch a coroutine to make the network call
            MainScope().launch {
                // Check that the prompt isn't empty before calling the API
                if (promptText.isNotBlank()) {

                    val thinkingEntry = "\n\n👤 You: $promptText\n🤖 AI: Thinking..."

                    // PREPEND the thinking status to the history (for bottom-up display)
                    val existingContent = responseTextView.text.toString()
                    responseTextView.text = thinkingEntry + existingContent


                    try {
                        // To generate text output, call generateContent with the String input
                        val response = model.generateContent(promptText)
                        val newResponseText = response.text ?: "No response generated."

                        // Construct the final Q&A entry
                        val finalQAndAEntry = "\n\n👤 You: $promptText\n🤖 AI: $newResponseText"

                        // Replace the "Thinking..." text with the final answer
                        responseTextView.text = responseTextView.text.toString().replace(thinkingEntry, finalQAndAEntry)

                    } catch (e: Exception) {
                        // Handle any API errors. Replace the "Thinking..." text with the error.
                        // Ensure that e.message is safely converted to a string for display
                        val errorMessage = "\n\n👤 You: $promptText\n🤖 AI Error: ${e.message ?: "Unknown Error"}"
                        responseTextView.text = responseTextView.text.toString().replace(thinkingEntry, errorMessage)
                    }
                } else {
                    // If the prompt is empty, prepend a warning message
                    responseTextView.text = "\n\nPlease enter a prompt." + responseTextView.text.toString()
                }

            }
        }
    }

}
