package com.lekciya.roomshow.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface itemDAO {
    @Query("SELECT * FROM items")
    fun getAllItems() : List<Item>


    @Insert
    fun insertItem(item : Item)

    @Update
    fun updateItem(item: Item)

    @Delete
    fun deleteItem(item: Item)

    @Query("SELECT * FROM items WHERE id = :id")
    fun getItemById(id : Int) : Item?

}