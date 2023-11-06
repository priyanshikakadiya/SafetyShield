package com.example.database_location

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ArticalsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articals)
    }

    fun openChrome(view: View) {
        val url = "https://www.vedantu.com/english/womens-safety-in-india-essay"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.`package` = "com.android.chrome"
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(webIntent)
        }



    }
}



