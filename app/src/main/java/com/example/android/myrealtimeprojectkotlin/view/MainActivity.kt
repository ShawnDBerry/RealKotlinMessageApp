package com.example.android.myrealtimeprojectkotlin.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android.myrealtimeprojectkotlin.R
import com.example.android.myrealtimeprojectkotlin.model.Message
import com.example.android.myrealtimeprojectkotlin.viewmodel.RealViewModel

class MainActivity : AppCompatActivity() {

    private var viewModel: RealViewModel? = null

    private var messageObserver: Observer<Message>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProviders.of(this).get(RealViewModel::class.java)

        messageObserver = Observer { message ->
            addMessage(message)
        }

        viewModel!!.getLiveData().observe(this, messageObserver!!)
        val message = Message()
        message.messageTitle = "New Age Pimpin"
        message.messageDate = "01/15/20"
        message.userName = "Monique D. Berry"
        message.messageContent = "What's up to all my player's, Pimps out to get their scratch and Square trying to get it back!"
        viewModel!!.sendMessage(message)



    }
    fun addMessage(message: Message){
        Log.d("TAG_Q", "logMessage "+ message.messageContent)
    }
    }



