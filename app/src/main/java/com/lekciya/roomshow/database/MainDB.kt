package com.lekciya.roomshow.database

import androidx.room.*
import androidx.room.RoomDatabase
import kotlin.concurrent.Volatile

@Database(entities = [Item::class], version = 1)
abstract class MainDB : RoomDatabase() {

    abstract fun itemDao() : itemDAO

    companion object {
        @Volatile
        private var INSTANCE : MainDB? = null
    }
}