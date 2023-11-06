package com.example.database_location

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {



    private lateinit var  btnInsertData: Button
    private lateinit var  btnShowData: Button
    private  lateinit var btnCall: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInsertData = findViewById(R.id.btnInsertData)
        btnShowData = findViewById(R.id.btnShowData)


        btnInsertData.setOnClickListener {
            val  intent = Intent (this, ContactActivity::class.java)
            startActivity(intent)
        }

        btnShowData.setOnClickListener {
            val  intent = Intent (this, FetchcontactActivity::class.java)
            startActivity(intent)
        }












    }



}


