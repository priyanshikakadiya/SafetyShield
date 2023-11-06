package com.example.database_location

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class GridviewActivity: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gride)

        val imageButton1: ImageButton = findViewById(R.id.sos)

        imageButton1.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        val imageButton2: ImageButton = findViewById(R.id.callsms)

        imageButton2.setOnClickListener {
            val intent = Intent(this, FetchcontactActivity::class.java)
            startActivity(intent)
        }

        val imageButton3: ImageButton = findViewById(R.id.addcontacts)

        imageButton3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val imageButton4: ImageButton = findViewById(R.id.articals)

        imageButton4.setOnClickListener {
            val intent = Intent(this, ArticalsActivity::class.java)
            startActivity(intent)
        }

        val imageButton5: ImageButton = findViewById(R.id.profile)

        imageButton5.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        val imageButton6: ImageButton = findViewById(R.id.aboutus)

        imageButton6.setOnClickListener {
            val intent = Intent(this, AboutusActivity::class.java)
            startActivity(intent)
        }
    }
}