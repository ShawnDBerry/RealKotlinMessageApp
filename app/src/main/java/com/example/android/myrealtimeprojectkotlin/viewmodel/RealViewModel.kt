package com.example.android.myrealtimeprojectkotlin.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.android.myrealtimeprojectkotlin.model.Message
import com.example.android.myrealtimeprojectkotlin.util.Constants
import com.google.firebase.database.*

class RealViewModel(application: Application) : AndroidViewModel(application) {

    private var messageReference = FirebaseDatabase.getInstance().getReference(Constants().DATABASE_PATH)

    private var messageMutableLiveData = MutableLiveData<Message>()

    init {

        messageReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Log.d("TAG_Q", "log message: " + databaseError.message)
            }

            override fun onDataChange(databaseSnapshot: DataSnapshot) {
                Log.d("TAG_Q", "log message: " + databaseSnapshot.children)
                for (currentData: DataSnapshot in databaseSnapshot.children) {
                    Log.d("TAG_Q", "log message" + 100)
                    messageMutableLiveData.value = currentData.getValue(Message::class.java)
                }
            }

        })
    }

    fun sendMessage(message: Message) {
       val childKey = messageReference.push().key
        if (childKey != null){
            messageReference.child(childKey).setValue(message)
        }
    }

    fun getLiveData(): MutableLiveData<Message>{
        return messageMutableLiveData
    }
}