package com.example.myevents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
//class SecondActivity : AppCompatActivity() {
//    private var selectedItem: String = ""
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_second)
//
//        val spinner: Spinner = findViewById(R.id.spinner)
//        val optionsAdapter = ArrayAdapter.createFromResource(
//            this,
//            R.array.spinner_options,
//            android.R.layout.simple_spinner_item
//        )
//        optionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner.adapter = optionsAdapter
//
//        // Add a hint item to the spinner
//        val hintAdapter = ArrayAdapter.createFromResource(
//            this,
//            R.array.spinner_hint,
//            android.R.layout.simple_spinner_item
//        )
//        hintAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        val fullAdapter = ArrayAdapter.createFromResource(
//            this,
//            R.array.spinner_full,
//            android.R.layout.simple_spinner_item
//        )
//        fullAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner.prompt = "CHOOSE HERE"
//        spinner.adapter = hintAdapter
//        spinner.setSelection(hintAdapter.count)
//
//        // Set onItemSelectedListener for the spinner
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                // Don't do anything if the hint item is selected
//                if (position == hintAdapter.count) {
//                    return
//                }
//
//                val selectedItem = parent.getItemAtPosition(position).toString()
//                if (selectedItem == "SEE EVENTS") {
//                    // Start SeeEventsActivity
//                    val intent = Intent(this@SecondActivity, SeeEventsActivity::class.java)
//                    startActivity(intent)
//                } else if (selectedItem == "ADD EVENTS") {
//                    // Start AddEventsActivity
//                    val intent = Intent(this@SecondActivity, AddEventsActivity::class.java)
//                    startActivity(intent)
//                }
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {
//                // Do nothing
//            }
//        }
//    }
//}
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
                val intent = Intent(this@SecondActivity, AddEventsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

