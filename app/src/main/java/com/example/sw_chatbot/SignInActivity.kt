package com.example.sw_chatbot

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val sp: SharedPreferences =this.getSharedPreferences("user", Activity.MODE_PRIVATE)
        val textid:EditText=findViewById(R.id.loginId)
        val textpwd:EditText=findViewById(R.id.loginPwd)
        val loginBtn:Button=findViewById(R.id.signin_btn)

        loginBtn.setOnClickListener{
            if(textid.text.toString().equals(sp.getString("id",""))&&textpwd.text.toString().equals(sp.getString("pwd",""))){
                Toast.makeText(this,sp.getString("name","")+"님, 로그인성공",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@SignInActivity,MainActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this,"로그인실패",Toast.LENGTH_SHORT).show()
            }
        }

        val signupBtn:Button=findViewById(R.id.signup_btn)
        signupBtn.setOnClickListener{
                startActivity(Intent(this@SignInActivity,SignUpActivity::class.java))
                finish()
            }
    }
}