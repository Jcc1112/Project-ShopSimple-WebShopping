package com.example.project

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import com.example.project.databinding.SignupBinding
import com.google.firebase.auth.FirebaseAuth


class signup : AppCompatActivity() {

    private lateinit var binding: SignupBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= SignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

            firebaseAuth = FirebaseAuth.getInstance()

            binding.text2.setOnClickListener {
                val intent = Intent(this, Main2::class.java)
                startActivity(intent)
            }

            binding.signup.setOnClickListener {
                val email = binding.EmailAddress.text.toString()
                val password= binding.password.text.toString()
                val compass= binding.confirepassword.text.toString()

                if(email.isNotEmpty() && password.isNotEmpty() && compass.isNotEmpty() ) {

                    if (password.equals(compass)) {

                        firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    val intent = Intent(this, Main2::class.java)
                                    startActivity(intent)
                                } else {
                                    Toast.makeText(
                                        this,
                                        it.exception.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()

                                }
                            }
                    } else {
                        Toast.makeText(this, "Password Not Matching", Toast.LENGTH_SHORT).show()
                    }
                }
               else
                {
                    Toast.makeText(this , "Empty Fields not allowed", Toast.LENGTH_SHORT).show()
                }

            }


        }
    }