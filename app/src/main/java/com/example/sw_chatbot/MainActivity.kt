package com.example.sw_chatbot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val regi:RelativeLayout=findViewById(R.id.registration)
        val chat:RelativeLayout=findViewById(R.id.chat)

        chat.setOnClickListener {
            startActivity(Intent(this,ChatActivity::class.java))
            finish()
        }

        regi.setOnClickListener {
            startActivity(Intent(this,RegistActivity::class.java))
            finish()
        }
    }
}