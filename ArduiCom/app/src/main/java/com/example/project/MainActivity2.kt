package com.example.project

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract

class MainActivity2: AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private var activePopupMenu: PopupMenu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        firebaseAuth = FirebaseAuth.getInstance()

        val aibtn= findViewById<Button>(R.id.aibot)
        aibtn.setOnClickListener {
            val intent6 = Intent(this, AI::class.java)
            startActivity(intent6)
            true
        }

        val profilebtn= findViewById<ImageView>(R.id.profile_icon)
        profilebtn.setOnClickListener {
            val intent5 = Intent(this, Profile::class.java)
            startActivity(intent5)
            true
        }

        val buybtn= findViewById<ImageView>(R.id.nav_icon_5)
        buybtn.setOnClickListener {
            val intent6 = Intent(this, ComponentShop::class.java)
            startActivity(intent6)
            true
        }

        val chatbtn= findViewById<ImageView>(R.id.nav_icon_4)
        chatbtn.setOnClickListener {
            val intent7 = Intent(this, Chart::class.java)
            startActivity(intent7)
            true
        }

        val tinkerbtn= findViewById<ImageView>(R.id.nav_icon_3)
        tinkerbtn.setOnClickListener {
            val intent8= Intent(this, Tinkercad::class.java)
            startActivity(intent8)
            true
        }

        val imagebt = findViewById<ImageView>(R.id.nav_icon_1)
        imagebt.setOnClickListener { view ->
            val popupMenu0 = PopupMenu(this, view)
            popupMenu0.inflate(R.menu.components)


            popupMenu0.setOnMenuItemClickListener { menuItem ->

                when (menuItem.itemId) {

                    R.id.i1 -> {

                        val intent = Intent(this, basic::class.java)
                        startActivity(intent)
                        true

                    }

                    R.id.i2 -> {

                        val intent2 = Intent(this, Sensor::class.java)
                        startActivity(intent2)
                        true
                    }

                    R.id.i3 -> {

                        val intent3 = Intent(this, Actuators::class.java)
                        startActivity(intent3)
                        true
                    }

                    R.id.i4 -> {

                        val intent4 = Intent(this, Communication_Modules::class.java)
                        startActivity(intent4)
                        true
                    }

                    R.id.i5 -> {

                        Toast.makeText(this, "Basic", Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false
                }
            }
            // THIS LINE IS THE FIX
            popupMenu0.show()
        }

        val imagebtn2 = findViewById<ImageView>(R.id.nav_icon_2)
        imagebtn2.setOnClickListener { view1 ->
            val popupMenu1 = PopupMenu(this, view1)
            popupMenu1.inflate(R.menu.project)

            popupMenu1.setOnMenuItemClickListener { menuItem ->

                when (menuItem.itemId) {

                    R.id.it1 -> {

                        val intent5 = Intent(this, Project::class.java)
                        startActivity(intent5)
                        true
                    }

                    R.id.it2 -> {

                        val intent5 = Intent(this, Project::class.java)
                        startActivity(intent5)
                        true
                    }
                    R.id.it3 -> {

                        val intent5 = Intent(this, Project::class.java)
                        startActivity(intent5)
                        true
                    }

                    else -> false
                }
            }
            popupMenu1.show()


        }


    }

}

