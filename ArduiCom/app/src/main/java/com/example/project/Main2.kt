package com.example.project

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.Page2Binding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.google.firebase.Firebase
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.auth

@Suppress("DEPRECATION")
class Main2 : AppCompatActivity() {

    private lateinit var binding: Page2Binding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    private val activity = this

    // For Google Sign-in: Handles the result from the Google Sign-in Intent.
    private val googleSignInLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleGoogleSignInResult(task)
            }
        }


    // For GitHub Sign-in: Handles the result from the Firebase UI sign-in Intent.
    // It automatically manages the sign-in process and returns a result.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Page2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        // Configure Google Sign-In options.
        val gsa = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gsa)

        // Set listeners for your UI elements.
        binding.text2.setOnClickListener {
            val intent2 = Intent(this, signup::class.java)
            startActivity(intent2)
        }

        binding.login.setOnClickListener {
            val email = binding.EmailAddress.text.toString()
            val password = binding.password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        // Login is successful, now save the state and navigate.

                        // 1. Save the login state to shared preferences
                        val sharedPref = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                        with(sharedPref.edit()) {
                            putBoolean("isLoggedIn", true)
                            apply()
                        }

                        // 2. Navigate to the main screen
                        val intent = Intent(this, MainActivity2::class.java)
                        startActivity(intent)

                        // 3. Finish the LoginActivity
                        finish()

                    } else {
                        // Login failed, show the user an error message
                        Toast.makeText(this, "Incorrect Login", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                // Handle empty email or password
                Toast.makeText(this, "Email and Password cannot be empty", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.google.setOnClickListener {
            signInWithGoogle()
        }

        /*binding.github.setOnClickListener {
            signInWithGithub()
        }*/
    }

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        googleSignInLauncher.launch(signInIntent)
    }

    private fun handleGoogleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)!!
            firebaseAuthWithGoogle(account.idToken!!)
        } catch (e: ApiException) {
            Toast.makeText(this, "Google Sign-In failed: " + e.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    Toast.makeText(
                        this,
                        "Authentication successful: ${user?.email}",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent7 = Intent(this, MainActivity2::class.java)
                    startActivity(intent7)
                    finish()
                } else {
                    Toast.makeText(
                        this,
                        "Firebase authentication with Google failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    // New function to handle GitHub sign-in using Firebase UI.


    override fun onStart() {
        super.onStart()
        // Get the current user from Firebase Auth
        val currentUser = firebaseAuth.currentUser

        // If the user is not null, they are already signed in.
        if (currentUser != null) {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish() // Prevents returning to the login screen
        }
    }
    }




