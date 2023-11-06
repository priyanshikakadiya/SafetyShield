package com.example.database_location

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.database_location.databinding.ActivityProfile2Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ProfileActivity2 : AppCompatActivity() {

    private  lateinit var  binding: ActivityProfile2Binding
    private  lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfile2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        binding.savebtn.setOnClickListener {

            val name = binding.edittext1.text.toString()
            val email = binding.edittext2.text.toString()
            val mobileno = binding.edittext3.text.toString()


            val user = User(name, email, mobileno)
            if(uid != null){

                databaseReference.child(uid).setValue(user).addOnCompleteListener{

                    if(it.isSuccessful){



                    }else{
                        Toast.makeText(this@ProfileActivity2,"Failed to update profile",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }










    }
}