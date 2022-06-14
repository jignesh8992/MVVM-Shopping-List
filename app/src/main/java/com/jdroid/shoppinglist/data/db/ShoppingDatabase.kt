package com.jdroid.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jdroid.shoppinglist.data.db.entities.ShoppingListItems

@Database(entities = [ShoppingListItems::class], version = 1, exportSchema = false)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingListDao(): ShoppingListDao

    companion object {
        @Volatile
        var instance: ShoppingDatabase? = null
        val LOCK = Any()
        operator  fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, ShoppingDatabase::class.java, "ShoppingList.db").build()
    }

}