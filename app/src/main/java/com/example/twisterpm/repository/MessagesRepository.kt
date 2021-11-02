package com.example.twisterpm.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.twisterpm.models.Message
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MessagesRepository {
    private val url = "https://anbo-restmessages.azurewebsites.net/api/"
    private val messageService: MessageService
    private val commentsService: MessageService
    val messageLiveData: MutableLiveData<List<Message>> = MutableLiveData<List<Message>>()
    val commentsLiveData: MutableLiveData<List<Message>> = MutableLiveData<List<Message>>()
    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()
    val updateMessageLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        val messagesbuild: Retrofit =
            Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        Log.d("APPLE","usemessageurl")
        messageService = messagesbuild.create(MessageService::class.java)
        Log.d("APPLE","messageService")
        getMessages()
        Log.d("APPLE","getmessages")
        val commentsbuild: Retrofit =
            Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        commentsService = commentsbuild.create(MessageService::class.java)

    }

    fun getMessages() {
        messageService.getAllMessages().enqueue(object : Callback<List<Message>> {
            override fun onResponse(
                call: Call<List<Message>>,
                response: Response<List<Message>>
            ) {
                Log.d("APPLE", "getmessagesu")
                if (response.isSuccessful) {
                    messageLiveData.postValue(response.body())
                    errorMessageLiveData.postValue("")
                    Log.d("APPLE","godt "+response.body().toString())
                }
                else{
                    Log.d("APPLE","skidt "+response.toString())
                }
            }

            override fun onFailure(call: Call<List<Message>>, t: Throwable) {
                errorMessageLiveData.postValue(t.message)
                Log.d("APPLE","errorMes")
            }
        })
    }

    fun addMessage(message: Message) {
        messageService.newMessage(message).enqueue(object : Callback<Message> {
            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                if (response.isSuccessful) {
                    updateMessageLiveData.postValue("Added" + response.body())
                } else {
                    val message = response.code().toString() + "" + response.message()
                    errorMessageLiveData.postValue(message)
                }
            }

            override fun onFailure(call: Call<Message>, t: Throwable) {
                errorMessageLiveData.postValue(t.message)
            }
        })
    }
    fun selectedMessage(message: Message){
        messageService.getMessageById(messagesId = message.id).enqueue(object : Callback<Message>
        {
            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                if (response.isSuccessful){
                    messageLiveData.value
                }
                else{
                    Log.d("APPLE","can't sellect" + response.message().toString())
                }
            }

            override fun onFailure(call: Call<Message>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}