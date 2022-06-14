package com.jdroid.shoppinglist.ui.shoppinlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jdroid.shoppinglist.data.repository.ShoppingListRepository

class ShoppingListViewModelFactory(private val repository: ShoppingListRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingListViewModel(repository) as T
    }
}