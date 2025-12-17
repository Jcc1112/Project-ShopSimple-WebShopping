package com.example.project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LED_buy: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.led_buy)

        val back = findViewById<ImageView>(R.id.Back_icon)
        back.setOnClickListener {

            val intent = Intent(this, ComponentShop::class.java)
            startActivity(intent)


        }

        val flipbtn = findViewById<ImageButton>(R.id.flipkart)
        flipbtn.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.flipkart.com/samaes-50-pics-5mm-red-led-light-electronic-hobby-kit/p/itmaac67d2626f48?pid=EHKG8ZHDRGTGMGPS&lid=LSTEHKG8ZHDRGTGMGPSLREJTB&marketplace=FLIPKART&cmpid=content_electronic-hobby-kit_8965229628_gmc"))
            startActivity(intent)
        }
        val amabtn = findViewById<ImageButton>(R.id.amazon)
        amabtn.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.amazon.in/Electronic-Spices-Light-Emitting-Diode/dp/B0B4K5HKDB/ref=sr_1_7?crid=3Q53A4JISKGYR&dib=eyJ2IjoiMSJ9.Ymvucl-YZV0oZGu-dCOXtiO97iwtU37O6mnlF2DMzA3w-Qkr9gOIPDhnmOrh3gHz42UfV_iy4Se3QIAHM3KOkqHQC7iATteRzbM8nl1Wv2lncZsbRYLEIE2pDUZyd2KuZ_ZwB3JzO97osaxI8p_O68D5Knhu25u9jFcNg4OVpDywm-n5a4qqQoseEHulKvGhL38Iu7dM4Y4hoqAirotiIfcy3GIMrI5TEGanOEt_M1NJSfNL9fGfxKjoEspO5Y7fspM_y5ISKqma5GrSbAmiMVWn9J5e9ICwZ02VgCB0UXo.WVdiK0VDpUzYxD_xLj0HNakinWvP3XIlrRvMAMc0E88&dib_tag=se&keywords=red%2Bled&qid=1757869890&sprefix=red%2Bled%2Caps%2C262&sr=8-7&th=1"))
            startActivity(intent)
        }
    }
}