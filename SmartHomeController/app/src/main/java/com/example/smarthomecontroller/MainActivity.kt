package com.example.smarthomecontroller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val livingRoomButton = findViewById<Button>(R.id.button_living_room)
        val kitchenButton = findViewById<Button>(R.id.button_kitchen)
        val bathroomButton = findViewById<Button>(R.id.button_bathroom)

        livingRoomButton.setOnClickListener {
            val intent = Intent(this, LivingRoomActivity::class.java)
            startActivity(intent)
        }

        kitchenButton.setOnClickListener {
            val intent = Intent(this, KitchenActivity::class.java)
            startActivity(intent)
        }

        bathroomButton.setOnClickListener {
            val intent = Intent(this, BathroomActivity::class.java)
            startActivity(intent)
        }
    }
}

