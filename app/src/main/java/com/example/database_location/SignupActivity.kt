package com.example.database_location

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.database_location.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth


class SignupActivity : AppCompatActivity() {





    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signup12.setOnClickListener {
            val name = binding.sname.text.toString()
            val emailid = binding.semail.text.toString()
            val Password = binding.spassword.text.toString()
            val Mobile_No = binding.mobileno.text.toString()


            if (name.isNotEmpty() && emailid.isNotEmpty() && Password.isNotEmpty() && Mobile_No.isNotEmpty()) {

                firebaseAuth.createUserWithEmailAndPassword(emailid, Password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed", Toast.LENGTH_SHORT).show()
            }



        }
    }
}