package com.example.allinoneproject

import androidx.room.*

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers():List<User>

    @Update
    suspend fun updateUser(user:User)

    @Delete
    suspend fun deleteUser(user:User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()
}