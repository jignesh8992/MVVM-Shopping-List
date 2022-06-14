package com.jdroid.shoppinglist.ui.shoppinlist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.jdroid.shoppinglist.data.db.entities.ShoppingListItems
import com.jdroid.shoppinglist.databinding.DialogAddShoppingItemBinding

class AddShoppingItemDialog(context: Context, private val listener: OnAddItemListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please enter all the details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            listener.addShoppingItem(ShoppingListItems(name, amount.toInt()))
            dismiss()
        }


        binding.tvCancel.setOnClickListener {
            dismiss()
        }

    }

    interface OnAddItemListener {
        fun addShoppingItem(item: ShoppingListItems)
    }
}