package com.example.twisterpm.models

import java.io.Serializable

data class Message(val id: Int, val content: String, val user: String, val totalComments: Int): Serializable



