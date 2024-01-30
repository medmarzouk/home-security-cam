package com.example.secuhome
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.secuhome.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    // Initializing the ImageView
    //var rImage: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rImage = binding.image
        /*binding.button3.setOnClickListener{
            intent= Intent(this,stream::class.java)
            startActivity(intent)
        }*/
        val firebaseDatabase = FirebaseDatabase.getInstance()

        val databaseReference = firebaseDatabase.reference

        val getImage = databaseReference.child("image")

        getImage.addListenerForSingleValueEvent(
            object : ValueEventListener {
                override fun onDataChange(
                    dataSnapshot: DataSnapshot
                ) {

                    val link = dataSnapshot.getValue(
                        String::class.java
                    )

                    Picasso.get().load(link).into(rImage)
                }

                override fun onCancelled(
                    databaseError: DatabaseError
                ) {

                    Toast
                        .makeText(
                            this@MainActivity,
                            "Error Loading Image",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }
            })
    }
}