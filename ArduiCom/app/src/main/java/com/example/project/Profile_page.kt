package com.example.project

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.HtmlCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class Profile_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_page)

        val back = findViewById<ImageView>(R.id.Back_icon)
        back.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


            // Get a reference to the TextView using its ID
            val nameTextView = findViewById<TextView>(R.id.namefil)
            val user = FirebaseAuth.getInstance().currentUser
            if (user != null) {
                // User is signed in
                val displayemail = user.email // Get the user's display name (if available)

                // Check if the display name is not null or empty
                if (!displayemail.isNullOrEmpty()) {
                    // Set the TextView's text to the user's name
                    nameTextView.text = "$displayemail"
                } else {
                    // If the display name is not available, you can set a default text
                    nameTextView.text = "Not available"
                }
            } else {
                // No user is signed in, so you can set a default text or hide the TextView
                nameTextView.text = "Please sign in"
            }



        }

    }



