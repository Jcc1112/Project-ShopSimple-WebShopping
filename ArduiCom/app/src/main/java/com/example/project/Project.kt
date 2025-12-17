package com.example.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast


class Project : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tinkercadpro)

        val buybtn= findViewById<ImageView>(R.id.nav_icon_5)
        buybtn.setOnClickListener {
            val intent8 = Intent(this, ComponentShop::class.java)
            startActivity(intent8)
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
            val intent6 = Intent(this, Tinkercad::class.java)
            startActivity(intent6)
            true
        }

        val profilebtn= findViewById<ImageView>(R.id.profile_icon)
        profilebtn.setOnClickListener {
            val intent5 = Intent(this, Profile::class.java)
            startActivity(intent5)
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

                        Toast.makeText(this, "Basic", Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false
                }
            }
            popupMenu1.show()

        }

        val pro1 = findViewById<ImageView>(R.id.imageView1)
        pro1.setOnClickListener {
            val intent = Intent(this, project1::class.java)
            startActivity(intent)
        }

        val pro2 = findViewById<ImageView>(R.id.imageView2)
        pro2.setOnClickListener {
            val intent2 = Intent(this, project2::class.java)
            startActivity(intent2)
        }
    }
}