package com.example.sw_chatbot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mychatbot.bean.ChatBean

class ChatActivity : AppCompatActivity() {
    private var myAdapter: ChatAdapter? = null
    private var listData: ArrayList<ChatBean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        listData = ArrayList<ChatBean>()

        var listView = findViewById<RecyclerView>(R.id.listView)
        var layoutManagaer = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        listView?.setLayoutManager(layoutManagaer)

        myAdapter = ChatAdapter(listData!!)
        listView.adapter = myAdapter

        var chatting_edit = findViewById<EditText>(R.id.chatting_edit)
        var button_send = findViewById<ImageView>(R.id.button_send)
        var back=findViewById<ImageView>(R.id.chat_topback)
        back.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        button_send.setOnClickListener({
            //클릭 이벤트
            var bean = ChatBean()
            bean.msg = chatting_edit.text.toString()
            bean.type = "me"
            chatting_edit.text.clear()
            listData!!.add(bean)
            myAdapter!!.notifyDataSetChanged() //화면다시 그리기
        })
    }

    override fun onBackPressed() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}