package com.example.allinoneproject

interface UserRepository {
    suspend fun getUsers():List<User>
}