package com.example.notesapp.model


data class UserResposeLogout(
   val statuscode : Int,
   val message : String,
   val data : Map<String, Any> = emptyMap(),
    val success : Boolean
)
