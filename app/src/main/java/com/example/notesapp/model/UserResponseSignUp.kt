package com.example.notesapp.model

data class UserResponseSignUp(
    val statuscode : Int,
    val message : String,
    val data : User,
    val success : Boolean
)
