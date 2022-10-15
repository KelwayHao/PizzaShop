package com.kelway.pizzashop.presentation.menu.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelway.pizzashop.domain.model.Banner
import com.kelway.pizzashop.domain.model.Category
import com.kelway.pizzashop.domain.model.MenuItem
import com.kelway.pizzashop.domain.model.Pizza
import com.kelway.pizzashop.presentation.menu.viewholder.BannerViewHolder
import com.kelway.pizzashop.presentation.menu.viewholder.CategoryViewHolder
import com.kelway.pizzashop.presentation.menu.viewholder.MenuViewHolder
import com.kelway.pizzashop.presentation.menu.viewholder.PizzaViewHolder

class MenuAdapter : RecyclerView.Adapter<MenuViewHolder>() {
    private var items: List<MenuItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return when (viewType) {
            BannerViewHolder.VIEW_TYPE -> BannerViewHolder.newInstance(parent)
            CategoryViewHolder.VIEW_TYPE -> CategoryViewHolder.newInstance(parent)
            PizzaViewHolder.VIEW_TYPE -> PizzaViewHolder.newInstance(parent)
            else -> throw IllegalStateException("Wrong view holder type")
        }
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Banner -> BannerViewHolder.VIEW_TYPE
            is Category -> CategoryViewHolder.VIEW_TYPE
            is Pizza -> PizzaViewHolder.VIEW_TYPE
            else -> throw IllegalStateException("Wrong view view type")
        }
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(data: List<MenuItem>) {
        items = data
        notifyDataSetChanged()
    }
}