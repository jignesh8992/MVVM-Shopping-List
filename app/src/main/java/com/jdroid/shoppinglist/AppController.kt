package com.jdroid.shoppinglist

import android.app.Application
import com.jdroid.shoppinglist.data.db.ShoppingDatabase
import com.jdroid.shoppinglist.data.repository.ShoppingListRepository
import com.jdroid.shoppinglist.ui.shoppinlist.ShoppingListViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class AppController : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@AppController))

        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton { ShoppingListRepository(instance()) }
        bind() from provider {
            ShoppingListViewModelFactory(instance())
        }
    }
}