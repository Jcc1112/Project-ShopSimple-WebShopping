package com.example.project

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.credentials.ClearCredentialStateRequest
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.credentials.exceptions.ClearCredentialException
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch
import androidx.credentials.CredentialManager


class Profile : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var credentialManager: CredentialManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        firebaseAuth = FirebaseAuth.getInstance()
        credentialManager = CredentialManager.create(this)

        val probtn= findViewById<Button>(R.id.profile)
        probtn.setOnClickListener {
            val intent = Intent(this, Profile_page::class.java)
            startActivity(intent)

        }

        val back = findViewById<ImageView>(R.id.Back_icon)
        back.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }
        val logoutbtn = findViewById<Button>(R.id.logout)
        logoutbtn.setOnClickListener {
            signOut()
        }



    }
    private fun signOut() {
        // 1. Firebase Sign Out
        firebaseAuth.signOut()

        // 2. Clear Credential Manager state
        lifecycleScope.launch {
            try {
                val clearRequest = ClearCredentialStateRequest()
                credentialManager.clearCredentialState(clearRequest)
                Log.d(TAG, "Successfully cleared user credentials.")
            } catch (e: ClearCredentialException) {
                Log.e(TAG, "Couldn't clear user credentials: ${e.localizedMessage}")
            }
        }

        // 3. Clear the login state from SharedPreferences
        val sharedPref = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putBoolean("isLoggedIn", false)
            apply()
        }

        // 4. Update UI and navigate to the login screen
        updateUI(null) // Assuming this is part of your original `signOut` function
    }
    private fun updateUI(user: FirebaseUser?) {
        if (user == null) {
            // User is signed out.
            // Navigate to the login screen.
            val intent = Intent(this, Main2::class.java)
            startActivity(intent)
            finish() // Prevents the user from navigating back to the previous screen.
        }
    }


}


