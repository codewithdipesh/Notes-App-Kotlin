package com.example.notesapp.api

import com.example.notesapp.model.UserRequest
import com.example.notesapp.model.UserRequestPasswordChange
import com.example.notesapp.model.UserResponseSignUp
import com.example.notesapp.model.UserResposeChangePassword
import com.example.notesapp.model.UserResposeLogin
import com.example.notesapp.model.UserResposeLogout
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("/users/register")
    suspend fun register(@Body userRequest: UserRequest) : Response<UserResponseSignUp>

    @POST("/users/login")
    suspend fun login(@Body userRequest: UserRequest) : Response<UserResposeLogin>

    @POST("/users/change-password")
    suspend fun changePassword(@Body userRequestPasswordChange: UserRequestPasswordChange) : Response<UserResposeChangePassword>

    @POST("/users/logout")
    suspend fun logout() : Response<UserResposeLogout>
}