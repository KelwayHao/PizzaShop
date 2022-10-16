package com.kelway.pizzashop.presentation.menu.adapter

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kelway.pizzashop.R
import com.kelway.pizzashop.domain.model.Category
import com.kelway.pizzashop.domain.model.MenuItem
import com.kelway.pizzashop.presentation.listener.SelectingCategoryClickListener
import com.kelway.pizzashop.presentation.menu.viewholder.CategoryViewHolder

class CategoryAdapter(private val selectingCategoryListener: SelectingCategoryClickListener) :
    Adapter<CategoryViewHolder>() {
    private var items: List<MenuItem> = emptyList()
    private var selectedElement = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindItem(items[position])
        holder.frameItem.setBackgroundColor(holder.itemView.context.resources.getColor(R.color.white))
        holder.textView.apply {
            setTextColor(holder.itemView.context.resources.getColor(R.color.dark_gray))
            typeface = Typeface.DEFAULT
        }
        if (selectedElement == position) {
            holder.frameItem.setBackgroundColor(holder.itemView.context.resources.getColor(R.color.red_200))
            holder.textView.apply {
                setTextColor(holder.itemView.context.resources.getColor(R.color.red))
                typeface = Typeface.DEFAULT_BOLD
            }

            (items[position] as Category).apply {
                selectingCategoryListener.selectCategory(this.nameCategory)
            }
        }

        holder.itemView.setOnClickListener {
            val previousItem: Int = selectedElement
            selectedElement = holder.bindingAdapterPosition

            notifyItemChanged(previousItem)
            notifyItemChanged(position)
        }
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(data: List<MenuItem>) {
        items = data
        notifyDataSetChanged()
    }
}