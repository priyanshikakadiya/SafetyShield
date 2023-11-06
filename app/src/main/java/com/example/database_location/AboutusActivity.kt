package com.example.database_location

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AboutusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutus)

        val ourteam: Button = findViewById(R.id.ourteam)

        ourteam.setOnClickListener {
            val intent = Intent(this, OurTeamActivity::class.java)
            startActivity(intent)
        }
    }
}
