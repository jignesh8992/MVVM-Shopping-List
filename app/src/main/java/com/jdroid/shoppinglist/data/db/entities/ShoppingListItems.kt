package com.jdroid.shoppinglist.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShoppingListItems(var name: String, var amount: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}