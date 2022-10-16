package com.kelway.pizzashop.data.data

import com.kelway.pizzashop.R
import com.kelway.pizzashop.domain.model.Banner

class BannerDatabase() {
    companion object {
        val listBanner = listOf(
            Banner("", R.drawable.banner1),
            Banner("", R.drawable.banner2)
        )
    }
}