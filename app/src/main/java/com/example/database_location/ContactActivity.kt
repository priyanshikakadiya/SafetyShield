package com.example.database_location

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ContactActivity : AppCompatActivity()
{

    private  lateinit var etname: EditText
    private  lateinit var etcontactno: EditText
    private  lateinit var etemailid: EditText
    private  lateinit var btnAddData: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        etname = findViewById(R.id.editTextText)
        etcontactno = findViewById(R.id.editTextText2)
        etemailid = findViewById(R.id.editTextText3)
        btnAddData = findViewById(R.id.btnAddData)

        dbRef = FirebaseDatabase.getInstance().getReference("Contact")

        btnAddData.setOnClickListener {
            saveContactData()
        }

    }

    private  fun  saveContactData() {

        //getting data
        val name = etname.text.toString()
        val contactNo = etcontactno.text.toString()
        val emailId = etemailid.text.toString()

        if (name.isEmpty()){
            etname.error = "please enter name"
        }

        if (contactNo.isEmpty()){
            etcontactno.error = "please enter contact no"
        }

        if (emailId.isEmpty()){
            etemailid.error = "please enter email id"
        }

        val contactId = dbRef.push().key!!

        val contact = ContactModel(contactId, name, contactNo, emailId )

        dbRef.child(contactId).setValue(contact)
            .addOnCompleteListener{
                Toast.makeText(this, "Contact Number added", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }

    }
}