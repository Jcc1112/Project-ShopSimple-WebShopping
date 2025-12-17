package com.example.project

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val LoginBtn: Button = findViewById(R.id.LoginBtn)
        LoginBtn.setOnClickListener {

            val intent2 = Intent(this, Main2::class.java)
            startActivity(intent2)
        }
        val Signupbtn= findViewById<Button>(R.id.Signup)
        Signupbtn.setOnClickListener {

            val intent1= Intent(this, signup::class.java)
            startActivity(intent1)


                val sharedPref = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

                val intent: Intent = if (isLoggedIn) {
                    // User is logged in, go to the main screen
                    Intent(this, MainActivity2::class.java)
                } else {
                    // User is not logged in, go to the login screen
                    Intent(this, Main2::class.java)
                }

                startActivity(intent)
                finish() // Close this splash screen
            }

        }

    }

