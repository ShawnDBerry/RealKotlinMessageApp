package com.example.android.myrealtimeprojectkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.myrealtimeprojectkotlin.R
import com.example.android.myrealtimeprojectkotlin.model.Message

class RealAdapter(private var messageList: List<Message>, private var applicationContext: Context) : RecyclerView.Adapter<RealAdapter.RealViewHolder>() {

    class RealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_itemview, parent, false)

        return RealViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RealViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}