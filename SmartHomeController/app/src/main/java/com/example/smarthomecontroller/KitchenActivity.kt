package com.example.smarthomecontroller

import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class KitchenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kitchen)

        val aquaguardSwitch = findViewById<Switch>(R.id.switch_aquaguard)
        val fridgeSwitch = findViewById<Switch>(R.id.switch_fridge)
        val chimneySwitch = findViewById<Switch>(R.id.switch_chimney)

        // Implement your logic here to handle the switches
        aquaguardSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle Aquaguard switch logic
        }

        fridgeSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle Fridge switch logic
        }

        chimneySwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle Chimney switch logic
        }
    }
}