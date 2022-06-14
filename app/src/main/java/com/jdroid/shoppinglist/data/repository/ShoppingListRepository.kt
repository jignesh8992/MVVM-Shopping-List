package com.jdroid.shoppinglist.data.repository

import com.jdroid.shoppinglist.data.db.ShoppingDatabase
import com.jdroid.shoppinglist.data.db.entities.ShoppingListItems

class ShoppingListRepository(private val db: ShoppingDatabase) {

    suspend fun upsert(items: ShoppingListItems) = db.getShoppingListDao().upsert(items)

    suspend fun delete(items: ShoppingListItems) = db.getShoppingListDao().delete(items)

    fun getAllShoppingList() = db.getShoppingListDao().getAllShoppingItems()

}