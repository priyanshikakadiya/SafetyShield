package com.example.database_location

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class DetailsActivity : AppCompatActivity() {

    private  lateinit var  tvcontactId: TextView
    private lateinit var tvname: TextView
    private lateinit var tvcontactNo: TextView
    private lateinit var tvemailId: TextView
    private  lateinit var btnUpdate: Button
    private lateinit var  btnDelete: Button
    private lateinit var btnCall: Button
    private  lateinit var btnSms: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().reference

        initView()
        setValuesToViews()



    }



    private fun initView() {
        tvcontactId = findViewById(R.id.dcontactId)
        tvname = findViewById(R.id.dname)
        tvcontactNo = findViewById(R.id.dcontactNo)
        tvemailId = findViewById(R.id.demailId)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
        btnCall = findViewById(R.id.btnCall)
        btnSms = findViewById(R.id.btnSms)
    }

    private fun setValuesToViews() {
        tvcontactId.text = intent.getStringExtra("Id")
        tvname.text = intent.getStringExtra("name")
        tvcontactNo.text = intent.getStringExtra("contactNo")
        tvemailId.text = intent.getStringExtra("emailId")

    }

  




    //direct Call



/*
        fun callContact(view: View) {
            // Check for CALL_PHONE permission
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                // Retrieve the contact's phone number from Firebase
                databaseReference.child("Contact").child("-Nf6ONuIP9ZI_-tEHG3P").addListenerForSingleValueEvent(object :
                    ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                       val data= dataSnapshot.getValue<ContactModel>()
                        val contact=data?.contactNo

                        // Make a phone call
                        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$contact"))
                        startActivity(intent)
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Handle the error here
                    }
                })
            }
        }*/


    //________________________________________________________________________________________//

    private lateinit var databaseReference: DatabaseReference


                //_______________________________________________________________________________//
                fun callContact(view: View) {
                    val contactNo = tvcontactNo.text.toString()

                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(
                            this,
                            arrayOf(Manifest.permission.CALL_PHONE),
                            1
                        )
                    } else {
                        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$contactNo"))
                        startActivity(intent)
                    }
                }
                //________________________________________________________________________________________//









    //Send SMS

/*

        fun sendSms(view: View) {
            // Check for SEND_SMS permission
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.SEND_SMS),
                    1
                )
            } else {
                // Retrieve the contact's phone number from Firebase
                databaseReference.child("Contact").child("-Nf6ONuIP9ZI_-tEHG3P").addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val contactNo = dataSnapshot.child("contactNo").value.toString()

                        // Send SMS
                        sendTextMessage(contactNo, "Hello from your app!")
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Handle the error here
                    }
                })
            }
        }



        private fun sendTextMessage(contactNo: String, message: String) {
            @Suppress("DEPRECATION")
            val smsManager = SmsManager.getDefault()
            val sentIntent = PendingIntent.getBroadcast(this, 0, Intent("SMS_SENT"), PendingIntent.FLAG_IMMUTABLE)
            val deliveredIntent = PendingIntent.getBroadcast(this, 0, Intent("SMS_DELIVERED"), PendingIntent.FLAG_IMMUTABLE)

            smsManager.sendTextMessage(contactNo, null, message, sentIntent, deliveredIntent)
        }*/




    //_______________________________________________________________________________//

    fun sendSms(view: View) {
        val contactNo = tvcontactNo.text.toString()

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.SEND_SMS),
                2
            )
        } else {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$contactNo"))
            intent.putExtra("sms_body", "I am in problem please help me out!")
            startActivity(intent)
        }
    }


}
//_______________________________________________________________________________//



