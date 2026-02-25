package com.example.madlab_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etPanNumber : EditText = findViewById(R.id.etPanNumber)
        val etPinNumber : EditText = findViewById(R.id.etPinNumber)
        val btValidate : Button = findViewById(R.id.btValidate)

        btValidate.setOnClickListener {
            val pan = etPanNumber.text.toString().trim()
            val pin = etPinNumber.text.toString().trim()

            if(pan.isEmpty() || pin.isEmpty()){
                Toast.makeText(this, "Both the fields are required !", Toast.LENGTH_SHORT).show()
            }

            val panPattern = Regex("[A-Z0-9]{10}$")
            if(!pan.matches(panPattern)){
                Toast.makeText(this, "invalid PAN Number !",Toast.LENGTH_SHORT).show()
            }
            val pinPattern = Regex("[0-9]{6}$")
            if(!pin.matches(pinPattern)){
                Toast.makeText(this,"Invalid PIN number !", Toast.LENGTH_SHORT).show()
            }

            Toast.makeText(this,"Successfully Validated !!",Toast.LENGTH_SHORT).show()

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}