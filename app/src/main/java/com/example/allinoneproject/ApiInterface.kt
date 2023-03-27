package com.example.allinoneproject

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/users?page=2")
    suspend fun getUsers():Response<UserResponse>
}