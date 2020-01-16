package com.example.android.myrealtimeprojectkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.myrealtimeprojectkotlin.R
import com.example.android.myrealtimeprojectkotlin.model.Message
import kotlinx.android.synthetic.main.message_itemview.view.*

class RealAdapter(private var messageList: List<Message>, private var applicationContext: Context) : RecyclerView.Adapter<RealAdapter.RealViewHolder>() {

    class RealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val userName: TextView = itemView.message_username
        val messageDate: TextView = itemView.message_date
        val messageTitle: TextView = itemView.message_title
        val messageContent: TextView = itemView.message_content
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_itemview, parent, false)

        return RealViewHolder(view)
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: RealViewHolder, position: Int) {
       holder.userName.text = messageList[position].userName
        holder.messageDate.text = messageList[position].messageDate
        holder.messageTitle.text = messageList[position].messageTitle
        holder.messageContent.text = messageList[position].messageContent
    }
}