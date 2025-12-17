package com.example.project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PIR_buy: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pir_buy)

        val back = findViewById<ImageView>(R.id.Back_icon)
        back.setOnClickListener {

            val intent = Intent(this, ComponentShop::class.java)
            startActivity(intent)


        }

        val flipbtn = findViewById<ImageButton>(R.id.flipkart)
        flipbtn.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.flipkart.com/arduino-m222-hc-sr501-ir-pyroelectric-infrared-pir-motion-sensor-detector-module-temperature-controller-electronic-hobby-kit/p/itmf9zssgkjf2sgz?pid=EHKF9ZBHWHPS7BZS&lid=LSTEHKF9ZBHWHPS7BZS1J1YBG&marketplace=FLIPKART&q=pir+motion+sensor&store=tng%2Ft4r&srno=s_1_2&otracker=AS_QueryStore_OrganicAutoSuggest_2_3_na_na_ps&otracker1=AS_QueryStore_OrganicAutoSuggest_2_3_na_na_ps&fm=organic&iid=0fa2071d-b07f-47e9-ae17-a7f397cf82f3.EHKF9ZBHWHPS7BZS.SEARCH&ppt=pp&ppn=pp&ssid=fycad88tdc0000001757869810892&qH=c27265d94be3bed4"))
            startActivity(intent)
        }
        val amabtn = findViewById<ImageButton>(R.id.amazon)
        amabtn.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.amazon.in/Electronic-Spices-Motion-Detector-Sensor/dp/B0BHW9FXWH/ref=sr_1_5?crid=3GFZNJV56J77S&dib=eyJ2IjoiMSJ9.X9bgkP0h1Dv3M1ZkUzq4GGrWjdx-kDYiWJF_XMDovEkFCF7wObbjxwv7aBwtDJZyZhqZwg2_Zst9rD0E-pX8OsOa2v05FpRnNtMEFzJZdTfQgEmct2I1HxMUtoQb25S2I4sNCSE5L3qlrhQX2dGkiGDCm8NPkmrc7RSiuxW978zOTjRTBcyKxKsuKzUJ-zZlovA3S-zKjVbKDJWQ3eXGNuz56kcq8m2eLK9e_Xn7uArxDUM4Bx1tqzeVIPWxP0xnxQxrbRRK_3ZgXNwH7cYGIO8ErL9b4LyJ7EYPlRaPX2Y.eWCb2NmBQ_zVt_EgVvGPOGLlJfu_jePHQzeOfLpbMi4&dib_tag=se&keywords=pir&qid=1757870099&sprefix=pir%2Caps%2C261&sr=8-5"))
            startActivity(intent)
        }
    }
}