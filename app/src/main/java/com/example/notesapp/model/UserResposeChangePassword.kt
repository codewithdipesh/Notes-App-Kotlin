package com.example.notesapp.model


data class UserResposeChangePassword(
   val statuscode : Int,
   val message : String,
   val data : Map<String, Any> = emptyMap(),
    val success : Boolean
)
