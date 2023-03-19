package com.example.myevents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class SecondActivity : AppCompatActivity() {

    private var selectedItem: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Initialize spinner with options
        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.spinner_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        // Set onItemSelectedListener for the spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedItem = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        // Set onClickListener for the button
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            if (selectedItem == "SEE EVENTS") {
                val intent = Intent(this@SecondActivity, SeeEventsActivity::class.java)
                startActivity(intent)
            } else if (selectedItem == "ADD EVENTS") {
                val intent = Intent(this@SecondActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

