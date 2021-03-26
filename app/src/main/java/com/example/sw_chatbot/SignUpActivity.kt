package com.example.sw_chatbot

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val sp:SharedPreferences=this.getSharedPreferences("user", Activity.MODE_PRIVATE)
        val btn1: Button=findViewById(R.id.saveBtn)
        val id:EditText=findViewById(R.id.userId)
        val pwd:EditText=findViewById(R.id.userPwd)
        val pwdCk:EditText=findViewById(R.id.userPwdCk)
        val name:EditText=findViewById(R.id.userName)
        var back=findViewById<ImageView>(R.id.signup_topback)
        back.setOnClickListener {
            startActivity(Intent(this,SignInActivity::class.java))
            finish()
        }
        btn1.setOnClickListener{
            if(pwd.text.toString().equals(pwdCk.text.toString())){
                sp.edit().putString("id",id.text.toString()).apply()
                sp.edit().putString("pwd",pwd.text.toString()).apply()
                sp.edit().putString("name",name.text.toString()).apply()

                startActivity(Intent(this, SignInActivity::class.java))
                finish()
            }
            else{
                val alert=AlertDialog.Builder(this)
                    .setTitle("확인해주세요.")
                    .setMessage("비밀번호와 비밀번호 확인이 일치하지 않습니다.")
                    .setPositiveButton("확인",null)
                    .create()

                alert.show()
            }
        }
    }
}