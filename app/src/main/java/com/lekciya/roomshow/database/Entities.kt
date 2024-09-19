package com.lekciya.roomshow.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true) val Id : Int? = null,
    val name : String,
    val description : String
)