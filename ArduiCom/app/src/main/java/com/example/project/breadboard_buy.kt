package com.example.project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class breadboard_buy: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.breadboard_buy)

        val back = findViewById<ImageView>(R.id.Back_icon)
        back.setOnClickListener {

            val intent = Intent(this, ComponentShop::class.java)
            startActivity(intent)


        }

        val flipbtn = findViewById<ImageButton>(R.id.flipkart)
        flipbtn.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.flipkart.com/robo-robo-breadboard-400-mini-breadboard-400-points-solderless-probe-tester-electronic-hobby-kit/p/itm68451145922fe?pid=EHKGNJFJEZEDYJAK&lid=LSTEHKGNJFJEZEDYJAKI0NYSG&marketplace=FLIPKART&q=breadboard&store=tng%2Ft4r&srno=s_1_1&otracker=search&otracker1=search&fm=organic&iid=b5de247c-1d3b-421b-86c4-9e07a7f1ce61.EHKGNJFJEZEDYJAK.SEARCH&ppt=pp&ppn=pp&ssid=hz694kro3k0000001757869743813&qH=67699cefeb2a7c60"))
            startActivity(intent)
        }
        val amabtn = findViewById<ImageButton>(R.id.amazon)
        amabtn.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://amazon.in/xcluma-Digital-Relative-Humidity-Temperature/dp/B072FJBF9T/ref=sr_1_8?crid=291WPIYCFEVGS&dib=eyJ2IjoiMSJ9.NYVq56VtbfNMLDVp36mj24D-Dw_H5wJ2M58wqoSyz-uYgFgDHszhe3HU5oxT8ykMPQF_p6-8Nb_5JSZ0fibNGSwp9hOlf13ny65ZBc1MwmHP5UpT09dpENgWYotepyL1qHpX6JUU-_HnbXOajZJO7Y-xKMQvJo0nrXQ_d3ov4J00lFl68h9WvaSzikQlJBSoaJkGmSNahvcg1wUOBNyLONWIYALKF6PVo4tG6Wz8o64A1tyoROC2fzet9bi8yIUFI3WvdmNSj_S0f5KRAWZuSfm4yI0HFwZuE_1NkfNGT_E.RasXPoedLOY3JK2IFcLpwQdLa6itpWOqBW7dbBUUEpw&dib_tag=se&keywords=DHT11&qid=1757869985&sprefix=dht11%2Caps%2C349&sr=8-8"))
            startActivity(intent)
        }
    }
}