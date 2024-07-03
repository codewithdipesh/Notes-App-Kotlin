package com.example.notesapp.model

data class LoginData(
    val user :User,
    val accesstoken : String,
    val refreshtoken : String
)
