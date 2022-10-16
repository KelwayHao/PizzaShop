package com.kelway.pizzashop.presentation.menu.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kelway.pizzashop.R
import com.kelway.pizzashop.databinding.ItemPizzaBinding
import com.kelway.pizzashop.domain.model.MenuItem
import com.kelway.pizzashop.domain.model.Pizza

class PizzaViewHolder(private val binding: ItemPizzaBinding) : MenuViewHolder(binding.root) {
    companion object {
        const val VIEW_TYPE = 3
        fun newInstance(parent: ViewGroup) = PizzaViewHolder(
            ItemPizzaBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_pizza, parent, false)
            )
        )
    }

    override fun bindItem(item: MenuItem) {
        (item as Pizza).apply {
            binding.namePizza.text = nameItem
            binding.descriptionPizza.text = descriptionItem
            binding.costPizza.text = binding.root.context.getString(R.string.cost_amount, costItem)
            binding.imagePizza.setImageResource(imageItem)
        }
    }
}