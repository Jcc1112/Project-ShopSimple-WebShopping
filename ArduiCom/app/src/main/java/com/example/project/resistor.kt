package com.example.project

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView


class resistor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resistor)

        val back = findViewById<ImageView>(R.id.Back_icon)
        back.setOnClickListener {

            val intent = Intent(this, basic::class.java)
            startActivity(intent)


        }


    }

}