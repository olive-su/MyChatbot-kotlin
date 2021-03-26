package com.example.sw_chatbot

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mychatbot.bean.ChatBean
import com.example.mychatbot.bean.ChatCkBean
import com.example.mychatbot.bean.ckboxBean
import com.google.gson.Gson

class ChatAdapter(list: ArrayList<ChatBean>?):RecyclerView.Adapter<ChatAdapter.ChatHolder>(){
    private var mList:ArrayList<ChatBean>?=null
    init{
        mList = list
    }

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):ChatHolder{
        val v =LayoutInflater.from(parent.context).inflate(R.layout.list_item_chat,parent,false)
        return ChatHolder(v)
    }
    override fun getItemCount():Int{
        return mList!!.size
    }
    override fun onBindViewHolder(holder:ChatHolder,position:Int){
        var item = mList?.get(position)
        var it=ckboxBean.ck.keys().iterator()
        var gson= Gson().fromJson(ckboxBean.ck.toString(),ChatCkBean::class.java)

        //초기화
        holder.chatLayout.visibility = View.GONE
        holder.textView_user.visibility = View.GONE

        if( item!!.type.equals("me") ){
            holder.textView_user.visibility = View.VISIBLE
            holder.textView_user.setText(item!!.msg)

            if( item!!.msg!!.contains("안녕") ){
                holder.chatLayout.visibility = View.VISIBLE
                holder.textView_chatbot.setText("안녕하세요")
            }

            while(it.hasNext()){
                val s=it.next().toString()
                if( item!!.msg!!.contains(s) ){
                    holder.chatLayout.visibility = View.VISIBLE
                    val a= ckboxBean.ck.getString(s)
                    holder.textView_chatbot.setText(a)
                }
            }
        }

    }
    class ChatHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        public var mView:View
        public var chatLayout:LinearLayout
        public var textView_chatbot:TextView
        public var textView_user:TextView

        init{
            mView = itemView
            chatLayout = mView.findViewById(R.id.chatLayout)
            textView_chatbot = mView.findViewById(R.id.textView_chatbot)
            textView_user = mView.findViewById(R.id.textView_user)

        }
    }
}