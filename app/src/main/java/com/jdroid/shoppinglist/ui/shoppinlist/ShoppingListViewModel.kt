package com.jdroid.shoppinglist.ui.shoppinlist

import androidx.lifecycle.ViewModel
import com.jdroid.shoppinglist.data.db.entities.ShoppingListItems
import com.jdroid.shoppinglist.data.repository.ShoppingListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingListViewModel(private val repository: ShoppingListRepository) : ViewModel() {

    fun upsert(items: ShoppingListItems) = CoroutineScope(Dispatchers.Main).launch { repository.upsert(items) }

    fun delete(items: ShoppingListItems) = CoroutineScope(Dispatchers.Main).launch { repository.delete(items) }

    fun getAllShoppingList() = repository.getAllShoppingList()
}