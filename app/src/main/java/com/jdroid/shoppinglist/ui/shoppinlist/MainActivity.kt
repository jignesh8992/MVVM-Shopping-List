package com.jdroid.shoppinglist.ui.shoppinlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.jdroid.shoppinglist.R
import com.jdroid.shoppinglist.data.db.ShoppingDatabase
import com.jdroid.shoppinglist.data.db.entities.ShoppingListItems
import com.jdroid.shoppinglist.data.repository.ShoppingListRepository
import com.jdroid.shoppinglist.databinding.ActivityMainBinding
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {


    override val kodein by kodein()
    private val factory: ShoppingListViewModelFactory by instance()

    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingListViewModel::class.java)

        val adapter = ShoppingListAdapter(listOf(), viewModel)
        mBinding.rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingList().observe(this) {
            adapter.shoppingListItems = it
            adapter.notifyDataSetChanged()
        }

        mBinding.fab.setOnClickListener {
            AddShoppingItemDialog(this@MainActivity, object : AddShoppingItemDialog.OnAddItemListener {
                override fun addShoppingItem(item: ShoppingListItems) {
                    viewModel.upsert(item)
                }
            }).show()
        }


    }
}