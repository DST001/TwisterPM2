package com.example.twisterpm.repository

import com.example.twisterpm.models.Message
import retrofit2.Call
import retrofit2.http.*

interface MessageService {
    @GET("messages")
    fun getAllMessages(): Call<List<Message>>
    @GET("messages/{messagesId}")
    fun getMessageById(@Path("messagesId") messagesId: Int): Call<Message>
    @POST("messages")
    fun newMessage(@Body message: Message): Call<Message>
    @DELETE("messages")
    fun deleteMessage(@Path("id") id: Int, @Body message: Message): Call<Message>
    @GET("messages/{messagesId}/comments")
    fun getAllComments()

}
