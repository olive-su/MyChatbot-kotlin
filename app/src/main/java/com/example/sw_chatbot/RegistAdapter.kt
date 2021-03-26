package com.example.sw_chatbot

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mychatbot.bean.RegistBean
import com.example.mychatbot.bean.ckboxBean
import org.json.JSONObject

class RegistAdapter(list:ArrayList<RegistBean>):RecyclerView.Adapter<RegistAdapter.RegistHolder>(){
    private var mList:ArrayList<RegistBean>?=null
    init{
        mList = list
    }

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):RegistHolder{
        val v =LayoutInflater.from(parent.context).inflate(R.layout.list_item_regist,parent,false)
        return RegistHolder(v)
    }
    override fun getItemCount():Int{
        return mList!!.size
    }
    override fun onBindViewHolder(holder:RegistHolder,position:Int){
        var item = mList?.get(position)

        //초기화
        holder.enrollLayout.visibility = View.GONE
        holder.textView_suggest.visibility = View.GONE
        holder.textView_react.visibility = View.GONE

        if( item!!.Rtype.equals("enroll") ){
            holder.enrollLayout.visibility=View.VISIBLE
            holder.textView_suggest.visibility = View.VISIBLE
            holder.textView_suggest.setText(item!!.RsuggestMsg)

            holder.textView_react.visibility = View.VISIBLE
            holder.textView_react.setText(item!!.RreactMsg)

            ckboxBean.ck.put(item!!.RsuggestMsg,item!!.RreactMsg)
        }




    }
    class RegistHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        public var mView:View
        public var enrollLayout:LinearLayout
        public var textView_suggest:TextView
        public var textView_react:TextView

        init{
            mView = itemView
            enrollLayout = mView.findViewById(R.id.enrollLayout)
            textView_suggest = mView.findViewById(R.id.suggest)
            textView_react = mView.findViewById(R.id.react)
        }
    }
}
