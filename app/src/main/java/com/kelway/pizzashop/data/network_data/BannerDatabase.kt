package com.kelway.pizzashop.data.network_data

import com.kelway.pizzashop.R
import com.kelway.pizzashop.domain.model.Banner

class BannerDatabase() {
    companion object {
        val listBanner = listOf(
            Banner("first", R.drawable.banner1),
            Banner("second", R.drawable.banner2)
        )
    }
}