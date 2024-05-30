package com.example.smarthomecontroller

import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class BathroomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bathroom)

        val washingMachineSwitch = findViewById<Switch>(R.id.switch_washing_machine)
        val showerSwitch = findViewById<Switch>(R.id.switch_shower)

        // Implement your logic here to handle the switches
        washingMachineSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle Washing Machine switch logic
        }

        showerSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle Shower switch logic
        }
    }
}