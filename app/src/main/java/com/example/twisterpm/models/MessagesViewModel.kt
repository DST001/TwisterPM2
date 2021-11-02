package com.example.twisterpm.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.twisterpm.repository.MessagesRepository

class MessagesViewModel: ViewModel() {
    private val repository = MessagesRepository()
    val messageLiveData: LiveData<List<Message>> = repository.messageLiveData
    val commentsLiveData: LiveData<List<Message>> = repository.commentsLiveData
    val errorMessageLiveData: LiveData<String> = repository.errorMessageLiveData
    val updateMessageLiveData: LiveData<String> = repository.updateMessageLiveData

    init {
    getPostsM()
        Log.d("APPLE","funrun")
    }
    fun getPostsM(){
        repository.getMessages()
        Log.d("APPLE","getfunfromre")
    }
    fun addMessage(message: Message){
        repository.addMessage(message)
    }
    fun selectedMessage(message: Message){
       // repository.selectedMessage(messagesLiveData.value.get(position))
    }
}