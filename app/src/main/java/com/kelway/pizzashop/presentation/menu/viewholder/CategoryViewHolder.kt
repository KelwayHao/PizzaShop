package com.kelway.pizzashop.presentation.menu.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kelway.pizzashop.R
import com.kelway.pizzashop.databinding.ItemCategoryBinding
import com.kelway.pizzashop.domain.model.Category
import com.kelway.pizzashop.domain.model.MenuItem
import com.kelway.pizzashop.presentation.listener.SelectingCategoryClickListener

class CategoryViewHolder(
    private val binding: ItemCategoryBinding,
) :
    MenuViewHolder(binding.root) {

    companion object {
        fun newInstance(
            parent: ViewGroup
        ) = CategoryViewHolder(
            ItemCategoryBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.item_category,
                        parent,
                        false
                    )
            )
        )
    }

    private val context = binding.root.context
    val frameItem = binding.frameItem
    val textView = binding.nameCategory

    override fun bindItem(item: MenuItem) {

        (item as Category).apply {
            binding.nameCategory.text = context.getString(nameCategory.nameItem)
        }
    }
}