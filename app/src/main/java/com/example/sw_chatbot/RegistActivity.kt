package com.example.sw_chatbot

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mychatbot.bean.RegistBean

class RegistActivity : AppCompatActivity() {
    private var myAdapter: RegistAdapter? = null
    private var RlistData: ArrayList<RegistBean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)

        RlistData = ArrayList<RegistBean>()

        var listView = findViewById<RecyclerView>(R.id.regist_list)
        var layoutManagaer = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        listView?.setLayoutManager(layoutManagaer)

        myAdapter = RegistAdapter(RlistData!!)
        listView.adapter = myAdapter

        var suggest_edit = findViewById<EditText>(R.id.suggestInput)
        var react_edit = findViewById<EditText>(R.id.reactInput)
        var button_save = findViewById<Button>(R.id.RsaveBtn)
        var back=findViewById<ImageView>(R.id.regist_topback)
        back.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        button_save.setOnClickListener({
            //클릭 이벤트
            var bean = RegistBean()
            bean.RsuggestMsg = suggest_edit.text.toString()
            bean.RreactMsg = react_edit.text.toString()
            bean.Rtype = "enroll"

            val Rsp:SharedPreferences=this.getSharedPreferences("regist", Activity.MODE_PRIVATE)
            Rsp.edit().putString(bean.RsuggestMsg,bean.RsuggestMsg).apply()
            Rsp.edit().putString(bean.RreactMsg,bean.RreactMsg).apply()

            suggest_edit.text.clear()
            react_edit.text.clear()

            RlistData!!.add(bean)
            myAdapter!!.notifyDataSetChanged() //화면다시 그리기
        })
    }

    override fun onBackPressed() {
        startActivity(Intent(this,MainActivity::class.java))
    }

}