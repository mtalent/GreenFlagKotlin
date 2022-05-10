package com.assignment.markgreenflagkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnMainCreate: TextView = findViewById<TextView>(R.id.tv_button)

        btnMainCreate.setOnClickListener {

            val intent = Intent(this, ActivityCreateAccount::class.java)
            // start your next activity
            startActivity(intent)


        }



    }









}