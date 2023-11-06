package com.example.database_location

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FetchcontactActivity : AppCompatActivity()

{
    private  lateinit var cRecyclerView: RecyclerView
    private  lateinit var tvLoadingData: TextView
    private  lateinit var  contactList: ArrayList<ContactModel>
    private  lateinit var  dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetchcontact)

        cRecyclerView =  findViewById(R.id.rvContact)
        cRecyclerView.layoutManager = LinearLayoutManager(this,)
        cRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        contactList = arrayListOf<ContactModel>()

        getContactData()
    }

    private  fun getContactData() {
        cRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("Contact")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                contactList.clear()
                if (snapshot.exists()){
                    for (contactSnap in snapshot.children){
                        val contactnoData = contactSnap.getValue(ContactModel::class.java)
                        contactList.add(contactnoData!!)
                    }
                    val mAdapter = ContactAdapter(contactList)
                    cRecyclerView.adapter = mAdapter


                    mAdapter.setOnItemClickListener(object  : ContactAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@FetchcontactActivity, DetailsActivity::class.java)

                            //put extras
                            intent.putExtra("contactId",contactList[position].contactId)
                            intent.putExtra("name",contactList[position].name)
                            intent.putExtra("contactNo",contactList[position].contactNo)
                            intent.putExtra("emailId",contactList[position].emailId)
                            startActivity(intent)
                        }

                    })

                    cRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility =  View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }

}