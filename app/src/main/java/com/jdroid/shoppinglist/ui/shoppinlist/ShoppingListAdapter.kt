package com.jdroid.shoppinglist.ui.shoppinlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jdroid.shoppinglist.data.db.entities.ShoppingListItems
import com.jdroid.shoppinglist.databinding.ShoppingItemBinding

class ShoppingListAdapter( var shoppingListItems: List<ShoppingListItems>, private val viewModel: ShoppingListViewModel) : RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListViewHolder {
        val binding = ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        val currShoppingItem = shoppingListItems[position]
        holder.bind(currShoppingItem)
    }

    override fun getItemCount(): Int {
        return shoppingListItems.size
    }

    inner class ShoppingListViewHolder(private val fBinding: ShoppingItemBinding) : RecyclerView.ViewHolder(fBinding.root) {
        fun bind(currShoppingItem: ShoppingListItems) {
            fBinding.apply {
                tvAmount.text = currShoppingItem.amount.toString()
                tvName.text = currShoppingItem.name
                ivDelete.setOnClickListener {
                    viewModel.delete(currShoppingItem)
                }
                ivPlus.setOnClickListener {
                    currShoppingItem.amount++
                    viewModel.upsert(currShoppingItem)
                }
                ivMinus.setOnClickListener {
                    if (currShoppingItem.amount > 0) {
                        currShoppingItem.amount--
                        viewModel.upsert(currShoppingItem)
                    }

                }
            }

        }
    }
}