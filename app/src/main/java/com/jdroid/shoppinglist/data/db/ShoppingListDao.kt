package com.jdroid.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.jdroid.shoppinglist.data.db.entities.ShoppingListItems

@Dao
interface ShoppingListDao {

    @Insert(onConflict = REPLACE)
    suspend fun upsert(shoppingItem: ShoppingListItems)

    @Delete
    suspend fun delete(shoppingItem: ShoppingListItems)

    @Query("SELECT * from ShoppingListItems")
    fun getAllShoppingItems(): LiveData<List<ShoppingListItems>>
}