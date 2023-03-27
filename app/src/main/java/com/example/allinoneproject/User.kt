package com.example.allinoneproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var email: String,
    @SerializedName("first_name")
    @ColumnInfo("first_name")
    var firstName: String,
    @SerializedName("last_name")
    @ColumnInfo("last_name")
    var lastName: String,
    var avatar: String
) {

}
