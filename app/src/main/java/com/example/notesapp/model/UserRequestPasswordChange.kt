package com.example.notesapp.model

data class UserRequestPasswordChange(
    val oldpassword : String,
    val newpassword : String
)
