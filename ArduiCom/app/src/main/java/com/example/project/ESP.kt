package com.example.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView


class ESP : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.esp)

        val back = findViewById<ImageView>(R.id.Back_icon)
        back.setOnClickListener {

            val intent = Intent(this, Actuators::class.java)
            startActivity(intent)


        }
        val code = findViewById<ImageView>(R.id.code1)
        code.setOnClickListener {
            val intent2= Intent(this, Code_led::class.java)
            startActivity(intent2)
        }

    }

}