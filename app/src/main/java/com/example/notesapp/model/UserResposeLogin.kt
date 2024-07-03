package com.example.notesapp.model

data class UserResposeLogin(
   val statuscode : Int,
   val message : String,
   val data : LoginData,
    val success : Boolean
)
