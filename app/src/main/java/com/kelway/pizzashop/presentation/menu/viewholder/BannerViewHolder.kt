package com.kelway.pizzashop.presentation.menu.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kelway.pizzashop.R
import com.kelway.pizzashop.databinding.ItemBannerBinding
import com.kelway.pizzashop.domain.model.Banner
import com.kelway.pizzashop.domain.model.MenuItem

class BannerViewHolder(private val binding: ItemBannerBinding) : MenuViewHolder(binding.root) {
    companion object {
        const val VIEW_TYPE = 1
        fun newInstance(parent: ViewGroup) = BannerViewHolder(
            ItemBannerBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_banner, parent, false
                    )
            )
        )
    }

    override fun bindItem(item: MenuItem) {
        (item as Banner).apply {
            binding.imageBanner.setImageResource(imageBanner)
        }
    }
}