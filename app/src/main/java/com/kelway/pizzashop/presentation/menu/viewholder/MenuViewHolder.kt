package com.kelway.pizzashop.presentation.menu.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kelway.pizzashop.domain.model.MenuItem

abstract class MenuViewHolder(itemView: View): ViewHolder(itemView) {
    abstract fun bindItem(item: MenuItem)
}