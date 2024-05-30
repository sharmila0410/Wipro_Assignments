package com.example.smarthomecontroller

import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class LivingRoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_living_room)

        val lightSwitch = findViewById<Switch>(R.id.switch_light)
        val acSwitch = findViewById<Switch>(R.id.switch_ac)
        val tvSwitch = findViewById<Switch>(R.id.switch_tv)

        // Implement your logic here to handle the switches
        lightSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle light switch logic
        }

        acSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle AC switch logic
        }

        tvSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle TV switch logic
        }
    }
}