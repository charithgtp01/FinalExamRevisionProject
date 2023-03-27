package com.example.allinoneproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: UserDatabase? = null
        fun getInstance(context: Context): UserDatabase {
            return INSTANCE
                ?: synchronized(this) {
                    INSTANCE ?: Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java, "user_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                        .also { INSTANCE = it }
                }

        }
    }
}