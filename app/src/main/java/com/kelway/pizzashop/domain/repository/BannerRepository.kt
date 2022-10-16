package com.kelway.pizzashop.domain.repository

import com.kelway.pizzashop.domain.model.Banner

interface BannerRepository {
    suspend fun getBannerDatabase(): List<Banner>
}